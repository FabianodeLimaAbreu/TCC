window.Modal = Spine.Controller.sub({
   elements:{
    ".modal-text":"content", 
    ".modal-text h2":"title", 
    ".modal-text p":"msg",
    ".dialog":"buttons",
    ".big-icon":"bigicon"
  }, events:{
      "click .bclose":"close", 
      "click .dialog a":"action"
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
    this.el.fadeOut();
    this.callback && this.callback();
  }, 
  /**
  * Redirect after save
  *
  * After the user click in "yes" at modal window, this method redirect to home page
  */
  refresh:function(){
    //window.location = "./";
    //$("body").removeClass("prevent");
    window.location.reload();
  },
  justClose:function(){
    this.el.fadeOut();
  },

  refreshBack:function(){
    window.history.go(-1);
  },

  /**
  * Question modal
  *
  * @param {String} a. Title message
  * @param {String} b. Content message
  * @param {Boolean} c. true to set bad Modal
  * @param {function} d. true to show bigicon
  * 
  * This method make a question to user. Use the param "a" and "b" to set it's content and title, and use "c" and "d" to set it's type and callback.
  */
  question: function(a, b, c, d) {
    a = a || "Titulo da Mensagem";
    b = b || "";
    this.buttons.removeClass("hide");
    this.content.removeClass("warning");
    c && this.content.addClass("warning");
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
    this.buttons.addClass("hide");
    this.content.removeClass("warning");
    c && this.content.addClass("warning");
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
    if(this.getRefreshStatus()){
      if(a.hasClass('yes')){
        this.close();
        if(this.getRefreshStatus()==="Deletar"){
          //Caso alem de dar refresh, vá deletar um dado do banco de dados
          this.callservice({"id":this.codToDelete},"DeletarLogic");
        }
        else{
          window.location.reload();
        }
      }
      else{
        this.close();
      }
    }
    else{
      if(a.hasClass('yes')){
        //Close modal
        window.history.go(-1);
        this.close();
      }
      else{
        //Else, just close modal
        this.close();
      }
    }
    
  },init:function() {
    this.codToDelete;
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
   
  },
  events:{
    
  },
  toggleSelect:function(status,link){
    if(status.hasClass("sel")){
      $(link+".combo").hide();
      status.removeClass("sel");
    }
    else{
      this.hide();
      $(link+".combo").show();
      status.addClass("sel");
    }
  },
  hide:function(){
    console.log("ok");
    $(".combo").hide();
    $(".bprompt").removeClass("sel");
  },
  /*setting:function(e){
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
  }*/
  popCombo:function(obj,link){
    console.dir(obj);
    var i,length,context=this,html="";
    length=obj.length;
    for(i=0;i<length;i++){
      html+="<li data='"+obj[i].id+"' class='"+link.pk+"' rel='"+link.foreign+"'>"+obj[i][""+link.collum].initialCaps()+"</li>";
    }
    $("."+link.pk+".combo").find(".combo-list").html(html);

    $(".combo-list li").click(function(){
      console.log($(this).attr("class"));
      console.dir($("form label[for='"+$(this).attr("class")+"']"));
        var data=$(this).attr("data");
        $("input[name='"+$(this).attr("rel")+"']").val(data);
        $("label[for='"+$(this).attr("rel")+"']").text($(this).text());
        context.hide();
    });
  },
});