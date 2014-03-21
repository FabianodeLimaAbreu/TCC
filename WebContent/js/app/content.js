window.Modal = Spine.Controller.sub({
   elements:{
    ".modal-content":"content", ".modal-text h2":"title", ".modal-text p":"msg",".modal-buttons":"buttons",".big-icon":"bigicon"
  }, events:{
      "click .bclose":"close", "click .modal-buttons a":"action"
  }, 
  /**
  * Close modal window
  *
  * @param {event} a. click event
  * 
  * This method close modal window
  */
  close:function(a) {
    if("object" === typeof a) {
      a.preventDefault(), $(a.target);
    }
    this.el.fadeOut(function() {
      $(this).attr('class','hide');
    });
    this.callback && this.callback();
  }, 
  /**
  * Redirect after save
  *
  * After the user click in "yes" at modal window, this method redirect to home page
  */
  save:function(){
    //window.location = "./";
    window.location.reload();
  },

  /**
  * Question modal
  *
  * @param {String} a. Title message
  * @param {String} b. Content message
  * @param {Boolean} c. true to set bad Modal
  * @param {function} d. true to set a callback function and show bigicon
  * 
  * This method make a question to user. Use the param "a" and "b" to set it's content and title, and use "c" and "d" to set it's type and callback.
  */
  question: function(a, b, c, d) {
    a = a || "Titulo da Mensagem";
    b = b || "";
    this.el.addClass("question");
    this.content.removeClass("bad");
    c && this.content.addClass("bad");
    d && this.bigicon.show();
    this.title.text(a.capitalize());
    this.msg.html(b);
    this.el.fadeIn();
    this.callback = null;
  },
  /**
  * Open modal
  *
  * @param {String} a. Title message
  * @param {String} b. Content message
  * @param {Boolean} c. true to set bad Modal
  * @param {function} d. receive a function to set a callback function and show bigicon
  * 
  * This method make a question to user. Use the param "a" and "b" to set it's content and title, and use "c" and "d" to set it's type and callback.
  */
  open:function(a, b, c, d) {
    a = a || "Titulo da Mensagem";
    b = b || "";
    this.content.removeClass("bad");
    c && this.content.addClass("bad");
    this.bigicon.hide();
    d && this.bigicon.show();
    this.title.text(a.capitalize());
    this.msg.html(b);
    this.el.fadeIn();
    if(d && "function" === typeof d)
      //If d is a function
      this.callback = d;
  },
  /**
  * Disable edit of page
  *
  * After modal, this method disable all functions of the page and reset onfocus table
  */
  disableedit:function(){
    this.bsave.fadeOut(); 
    this.content.removeClass("editing");
    $(".tab-2 input[name='description']").attr("disabled","disabled");
    $(".tab-2 input[name='search']").attr("disabled","disabled").val("");
    $(".product").removeClass("edit");
    $(".product .add-promo").addClass("remove");
    $(".onfocus .add-promo").removeClass("remove");
    $(".import").addClass("disabled").find(".filemask").addClass("disabled").find("input").attr("disabled","disabled");
    $( "input[name='endpromo']" ).attr("disabled","disabled");
    $(".end-desc").attr("disabled","disabled");
    $(".tab-2 .onfocus .scrollContent").empty().animate({
      height:0
    },"slow");
  },

  /**
  * After yes of cancel changes
  *
  * @param {event} a.event click.
  * After modal question, if user cancel all changes, this method has a call of some methods necessaries to reset all functions and objects
  */
  action:function(a) {
    if("object" === typeof a) {
      a.preventDefault(), a = $(a.target);
    }else {
      return!1;
    }
    if(a.hasClass('yes')){
      //If click in 'yes' button
      if(this.content.hasClass("editing")){
        //If is editing the page
          this.bedit.removeClass("sel");
          //Call methods
          this.clean();
          this.disableedit();
      }
      else{
        //Else editing page
        window.history.go(-1);
      }
      //Close modal
      this.close();
    }
    else{
      //Else, just close modal
      this.close();
    }
  },init:function() {
    this.itens = [];
}});

window.Content = Spine.Controller.sub({
  elements:{
    
  },
  events:{

  },

  init:function(){
    
  },
  reset:function() {
    
  }
});

/*Spotlight*/
window.Spotlight = Spine.Controller.sub({elements:{dd:"buttons"}, events:{"click dd":"select"}, select:function(a) {
  if("object" === typeof a) {
    a.preventDefault(), a = $(a.target);
  }else {
    return!1;
  }
  this.input.val(this.list + a.text()).focus().trigger("submit");
  this.close();
}, over:function(a) {
  a.addClass("sel");
  this.input.val(this.list + a.text()).focus();
}, close:function(a) {
  if(a && (a.preventDefault(), a = $(a.target), this.el.find(a).length)) {
    return!1;
  }
  a && a.hasClass("bsearch") && this.input.trigger("submit");
  this.input && this.input.focus();
  this.list = "";
  this.id = -1;
  this.doc.unbind("click");
  this.el.empty().fadeOut();
  return!1;
}, open:function(a) {
  var b, c, d, e = [], g;
  this.doc.unbind("click").bind("click", this.proxy(this.close));
  this.input = $(a.target);
  g = d = a.target.value;
  this.list && (d = d.replace(this.list, ""));
  if(2 > d.length) {
      return!1;
  }
  if(40 === a.keyCode || 38 === a.keyCode) {
    return this.arrow(a), !1;
  }
  if(48 <= a.keyCode && 90 >= a.keyCode || 8 == a.keyCode) {
    b = this.spot.filter(function(a) {
      return-1 !== a.VALUE.toLowerCase().indexOf(d.toLowerCase());
    });
    d = null;
    for(c in b) {
      b[c].DESC && (d === b[c].DESC ? e.push("<dd>" + b[c].VALUE + "</dd>") : (a = b.filter(function(a) {
        return a.DESC === b[c].DESC;
      }), a = 26 * a.length + 2, e.push("<dt style='height:" + a + "px'>" + b[c].DESC.capitalize() + "</dt><dd>" + b[c].VALUE + "</dd>"), d = b[c].DESC));
    }
    if(e.length){
        this.el.html(e.join(" ")).fadeIn();
        this.buttons = this.el.find("dd");
        return !1;
    }else{
       this.gettips(g);
       return !1;
    }
  }else {
    this.id = -1, 32 === a.keyCode && (this.list += d);
    }
}, hint:function(a, b) {
  var c, d, e = [];
  this.el.empty();
  if(!a.length)
    return !1;
  this.doc.unbind("click").bind("click", this.proxy(this.close));
  d = 26 * a.length + 10;
  e.push("<dt style='height:" + d + "px'>Você quis dizer:</dt>");
    for(c = 0;c < a.length;c++) {
        e.push("<dd>" + a[c].WORD.capitalize() + "</dd>");
    }
    this.el.html(e.join(" ")).fadeIn();
    this.buttons = this.el.find("dd");
}, arrow:function(a) {
  a = a || window.event;
  this.buttons.removeClass("sel");
  switch(a.keyCode) {
    case 38:
      this.id--;
      this.id < -this.buttons.length && (this.id = 0);
      a = this.buttons.eq(this.id);
      this.over(a);
      break;
    case 40:
      this.id++, this.id > this.buttons.length - 1 && (this.id = 0), a = this.buttons.eq(this.id), this.over(a);
  }
  return!1;
}, gettips: function(a){
    $.getJSON(nodePath + "SearchMaterial.svc/searchTermo/&query=" + a + "?callback=?", this.proxy(this.hint));
}, init:function() {
  this.spot = [];
  this.list = "";
  this.id = 0;
  this.input = null;
  this.doc = $(document);
  $.getJSON("ajax/spotlight.js", this.proxy(function(a) {
    this.spot = a;
  }));
}});