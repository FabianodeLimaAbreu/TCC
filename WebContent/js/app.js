require.config({
	shim: {
		spine: {
			deps: ["jquery"],
			exports: "Spine"
		}
	},
	baseUrl: "js/lib",
	paths: {
		app: "../app",
		models: "../models",
		sp: "spine"
	}
});
require(["methods", "sp/min", "app/content"], function() {
	window.App = Spine.Controller.sub({
		el: $("body"),
		elements: {
			"#container .content":"contentEl"
		},
		events: {
			"click .print":"print",
			"click .delete":"del",
			"click .edit":"edit"
		},
		init: function() {
			this.xml="";
			this.loading = !1;
			this.page = "Home";
			this.getxml();
			window.location="#"
			/*this.usr = jQuery.parseJSON($.cookie("portal"));
			if (!this.usr) {
				return this.logout(), !1;
			}*/
			//this.userTx.text(this.usr.Nome.capitalize());
			
			this.el.find("#wrap").removeClass("hide");
			this.content = new Content({
				
			});
			this.routes({
				"Usuarios/*func": function(a) {
					//Listagem de usuarios
					this.page="Usuarios";
					this.loaddata(a.func);
				},

				"Feriados/*func": function(a) {
					//Listagem de usuarios
					this.page="Feriados";
					this.loaddata(a.func);
				},	

				"Perfil/*func": function(a) {
					//Listagem de usuarios
					this.page="Perfil";
					this.loaddata(a.func);
				},
				"": function() {
					this.page = "Home";
					var context=this;
					$.ajax({
			            //verifica se existe o xml para load das paginas
			             type:"GET",
			             url:"load.xml",
			             dataType:"xml",
			             success:function(e){
			                context.xml=$(e).find("entry");
			                context.xml.each(function(){
					            if($(this).attr("name")==="Home"){
					               context.contentEl.html($(this).find("list").text());
					            }
					        });
							context.contentEl.fadeIn();
			             }
				    });
					this
				}
			});
		},
		callservice:function(obj,logic){
			obj.logica=logic; //Oque sera feito com a tabela
            obj.table=this.page; //tabela que sera afetada, a mesma que a pagina atual
            $.get("./mvc",obj)
            .error(function(){
            	alert("Não foi realizar a operação");
            })
            .success(function(){
            	alert("Operação realizada com sucesso");
            });
		},
		getxml:function(){
			var context=this;
			$.ajax({
	            //verifica se existe o xml para load das paginas
	             type:"GET",
	             url:"load.xml",
	             dataType:"xml",
	             success:function(e){
	                 context.xml=$(e).find("entry");
	             }
		    });
		},
		loaddata:function(load){
			var context=this;
			this.xml.each(function(){
	            if($(this).attr("name")===context.page){
	               context.contentEl.html($(this).find(load).text());
	            }
	        });
			this.contentEl.fadeIn();
		},
		print:function(a){
			a.preventDefault();
			window.print();
		},
		edit:function(a){
			a.preventDefault();
			var cod=parseInt($(a.target).attr("href").replace("#",""));
			this.callservice({"codigo":cod},"editar");
		},
		del:function(a){
			a.preventDefault();
			var cod=parseInt($(a.target).attr("href").replace("#",""));
			this.callservice({"codigo":cod},"deletar");
		},

		/**
		*	Reseting the application
		*
		*	@param {Boolean} nothome. This method say if the application is at home or not.
		*	
		*	This method hide all some objects of the page, clean the search value and call the Content Class's reset.
		*/

		reset: function(nothome) {
		}
	});
	new App; //Creates application
	Spine.Route.setup(); //Enables @route
});