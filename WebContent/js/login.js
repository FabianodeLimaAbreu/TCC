require.config({shim:{spine:{deps:["jquery"], exports:"Spine"}}, baseUrl:"js/lib", paths:{app:"../app", models:"../models", sp:"spine"}});
require(["methods", "sp/min", "app/content"], function() {
  window.App = Spine.Controller.sub({
  el:$("body")
   , elements:{
       "#modal":"modalEl", ".login input":"inputs",".box":"box"
  }, events:{
      "click .signin":"submit", "click .login .back":"getout","click .blogin":"getout","click .bforgot":"goforgot"
  }, init:function() {
    this.hash = window.location.hash.split('#')[1];
    //this.usr = jQuery.parseJSON($.cookie("portal"));
    //this.url = "http://189.126.197.163/node/express/setuser?query=";
    this.inputs.attr("autocomplete", "off");
    this.loading = !1;
    this.modal = new Modal({el:this.modalEl});
   // $.getJSON("http://189.126.197.163/node/test/starto.js?callback=?", this.proxy(function(a) {
    /*if(this.usr)
       window.location.href = './' + window.location.hash;*/
    this.box.addClass("loginop");
    this.el.fadeIn();
    //}));
  }, 
  goforgot:function(a){
    a.preventDefault();
    this.box.removeClass("loginop").addClass("forgotop");
  },
  submit:function(a) {
    a.preventDefault();
    var b,a, f = [], g, e = this;
    a = $("form.loginop").find(".form-control");
    console.log(a.length);
    /*$.each(a, function(a, c) {
      b = !1;
      if("login" === a  && !c) {
        return e.modal.open("Campo obrigat\u00f3rio n\u00e3o preenchido", "E-Mail inv\u00e1lido!", !0), !1;
      }
      if("password" === a && !c) {
         return e.modal.open("Campo obrigat\u00f3rio n\u00e3o preenchido", "Senha inv\u00e1lida!", !0), !1;
      }
      f.push(c);
      b = !0;
    });
    f = f.join("/");
    b && $.getJSON(this.url + f + "?callback=?", this.proxy(function(a) {
        if(a.TIPO && null !== a.TIPO) {
            $.cookie.json = true;
            $.cookie('portal',a,{expires: 7, path: '/'});
            window.location.href = './' + window.location.hash;
            return !1;
        }
        a = a.Mensagem || a.Nome || a;
        return e.modal.open("Erro", a, !0   ), !1;
    }));*/
    return!1;
  }, getout:function() {
    window.location = "login.jsp";
  }});
  new App;
});

