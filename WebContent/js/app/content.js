window.Modal = Spine.Controller.sub({
   elements:{
    ".modal-content":"content", 
    ".modal-text h2":"title", 
    ".modal-text p":"msg",
    ".dialog":"buttons",
    ".big-icon":"bigicon"
  }, events:{
      "click .bclose":"close", 
      "click .modal-buttons a":"action"
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

window.Formulario=Spine.Controller.sub({
  elements:{
    ".combo-input":"combovalue",
    ".bprompt":"bselect",
    "#combo li":"combolist",
    "#combo":"combo",
    "input[name='action']":"fake"
  },
  events:{
    "click .bprompt":"toggleSelect",
    "click #combo li":"setting"
  },
  toggleSelect:function(e){
    e.preventDefault();
    if($(e.target).hasClass("sel")){
      this.combo.hide();
      this.bselect.removeClass("sel");
    }
    else{
      this.combo.show();
      this.bselect.addClass("sel");
    }
  },
  hide:function(){
    this.combo.hide();
    this.bselect.removeClass("sel");
  },
  setting:function(e){
    e.preventDefault();
    var a=$(e.target).attr("data");
    this.fake.val(a);
    if(!$(e.target).hasClass("sel")){
      if(this.combolist.hasClass("sel")){
        this.combolist.removeClass("sel");
        $(e.target).addClass("sel");
      }
      else{
        $(e.target).addClass("sel");
      }
    }
    this.combovalue.val(a);
    this.hide();
  }
});