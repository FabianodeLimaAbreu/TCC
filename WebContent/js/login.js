require.config({shim:{spine:{deps:["jquery"], exports:"Spine"}}, baseUrl:"js/lib", paths:{app:"../app", models:"../models", sp:"spine"}});
require(["methods", "sp/min", "app/content"], function() {
  window.App = Spine.Controller.sub({
  el:$("body")
   , elements:{
       "#modal":"modalEl", ".login input":"inputs",".box":"box"
  }, events:{
      "click .signin":"submit", "click .login .back":"getout","click .blogin":"getout","click .bforgot":"goforgot","click .forgot":"submitforgot"
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
  submitforgot:function(a){
    a.preventDefault();
    var complet,inputs, e = this;
    inputs = $("form.forgotform").find(".form-control");
    $(inputs).each(function(index,val){
      complet = !1;
      if("email" === $(val).attr("name")  && (!val.value || val.value==="Email")) {
        return alert("Campo de email vazio");
        //return e.modal.open("Campo obrigat\u00f3rio n\u00e3o preenchido", "E-Mail inv\u00e1lido!", !0), !1;
      }
      complet = !0;
    });
    complet && $.get("./mvc",{'matricula':$("form input[name='numbermat']").val(),'password':$("form input[name='password']").val()})
    .error(function(){
      alert("Não foi possivel enviar senha");
    })
    .success(function(){
      alert("Senha enviada por email");
    });
  },
  submit:function(a) {
    a.preventDefault();
    var complet,inputs, e = this;
    inputs = $("form.loginform").find(".form-control");
    $(inputs).each(function(index,val){
      complet = !1;
      if("numbermat" === $(val).attr("name")  && (!val.value || val.value==="Número da matricula")) {
        //return e.modal.open("Campo de matricula vazio","Preencha-o corretamente para prosseguir",!0,!0)
        //return e.modal.open("Campo obrigat\u00f3rio n\u00e3o preenchido", "E-Mail inv\u00e1lido!", !0), !1;
      }
      if("password" === $(val).attr("name") && (!val.value || val.value==="Senha")) {
        //return e.modal.open("Campo de senha vazio","Preencha-o corretamente para prosseguir",!0,!0)
         //return e.modal.open("Campo obrigat\u00f3rio n\u00e3o preenchido", "Senha inv\u00e1lida!", !0), !1;
      }
      complet = !0;
    })
    complet && $.get("./mvc",{'matricula':$("form input[name='numbermat']").val(),'password':$("form input[name='password']").val()})
    .error(function(){
      alert("Não foi possivel efetuar o login");
    })
    .success(function(){
      alert("Usuario cadastrado com sucesso");
    });
        

        /*if(a.TIPO && null !== a.TIPO) {
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

