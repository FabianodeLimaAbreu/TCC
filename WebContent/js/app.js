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
require(["methods","jquery.webcam","jquery.maskedinput", "sp/min", "app/content"], function() {
	window.App = Spine.Controller.sub({
		el: $("body"),
		elements: {
			"#container .content":"contentEl",
			"#modal": "modalEl",
			".mask": "maskEl",
			".mask img": "loader",
			".finishform .submit":"bconfirm",
			".finishform .cancel":"bcancel",
			"#tperfil":"tperfil"
		},
		events: {
			"click .print":"print",
			"click .delete":"del",
			"click .edit":"edit",
			"click .finishform .submit": "submitform",
			"click .finishform .cancel": "cancel",
			"click .logout":"logout",
			"click .logo":"preventClick",
			"click nav .dropdown-menu a":"preventClick"
		},
		init: function() {			
			this.xml="";
			this.loading = !1;
			this.whatsave=""; //Este atributo diz se o operador equal a logica utilizada para java
			this.page = "Home";
			this.list;
			this.editactive=0;
			this.refreshStatus;
			this.prevent;
			this.setPerfil(this.tperfil.val().toLowerCase());
			/*this.usr = jQuery.parseJSON($.cookie("portal"));
			if (!this.usr) {
				return this.logout(), !1;
			}*/
			//this.userTx.text(this.usr.Nome.capitalize());
			
			this.el.find("#wrap").removeClass("hide");

			/*Cria os objetos a serem utilizados nas paginas*/
			this.content = new Content({
				setloading: this.proxy(this.setloading),
				mask: this.maskEl,
				el: this.contentEl
			});
			this.modal = new Modal({
				el: this.modalEl,
				getRefreshStatus:this.proxy(this.getRefreshStatus),
				callservice:this.proxy(this.callservice)
			});
			this.formulario=new Formulario({

			});

			/*Rotas de páginas*/
			this.routes({
				"Usuarios/*func": function(a) {
					//Listagem de usuarios
					this.setloading(!0,!1);
					this.page="Usuarios";
					this.loaddata(a.func);
				},

				"Feriados/*func": function(a) {
					//Listagem de usuarios
					this.setloading(!0,!1);
					this.page="Feriados";
					this.loaddata(a.func);
				},	

				"Perfis/*func": function(a) {
					//Listagem de usuarios
					this.setloading(!0,!1);
					this.page="Perfis";
					this.loaddata(a.func);
				},
				"Departamentos/*func": function(a) {
					//Listagem de usuarios
					this.setloading(!0,!1);
					this.page="Departamentos";
					this.loaddata(a.func);
				},
				"Operadores/*func": function(a) {
					//Listagem de usuarios
					this.setloading(!0,!1);
					this.page="Operadores";
					this.loaddata(a.func);
				},
				"Empresas/*func": function(a) {
					//Listagem de usuarios
					this.setloading(!0,!1);
					this.page="Empresas";
					this.loaddata(a.func);
				},

				/*DROPDOWN 2**/
				"Faixas_Acesso/*func": function(a) {
					//Listagem de usuarios
					this.setloading(!0,!1);
					this.page="Faixas_Acesso";
					this.loaddata(a.func);
					this.setloading(!1,!0);
				},
				"Zonas_Tempo/*func": function(a) {
					//Listagem de usuarios
					this.setloading(!0,!1);
					this.page="Zonas_Tempo";
					this.loaddata(a.func);
				},

				/*DROPDOWN 3*/
				"Status/*func": function(a) {
					//Listagem de usuarios
					this.setloading(!0,!1);
					this.page="Status";
					this.loaddata(a.func);
				},
				"Especiais/*func": function(a) {
					//Listagem de usuarios
					this.setloading(!0,!1);
					this.page="Especiais";
					this.loaddata(a.func);
				},
				"Visitantes/*func": function(a) {
					//Listagem de usuarios
					this.setloading(!0,!1);
					this.page="Visitantes";
					this.loaddata(a.func);
				},

				/*HOME*/
				"": function() {
					this.setloading(!0,!1);
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
							context.setloading(!1,!0);
			             }
				    });
				}
			});
		},

		setPerfil:function(cont){
			if(cont.indexOf("administrador")+1){
				this.el.addClass("admin");
				return !0;
			}
			else if(cont.indexOf("rh")+1){
				this.el.addClass("rh");
				return !0;
			}
			else{
				this.el.addClass("operador");
				return !0;
			}
		},
		/*Chama metodos java para executar funções no banco de dados*/
		callservice:function(obj,logic){
			console.dir(this.whatsave);
			var context=this;
			if(logic==="DeletarLogic"){
				obj.logica=logic; //Oque sera feito com a tabela
            	obj.table=this.page; //tabela que sera afetada, a mesma que a pagina atual
			}
            if(this.whatsave==="AdicionarLogic"){
            	if(!obj.id){
            		obj[0].id=0;
            	}
            	obj[0].logica=logic; //Oque sera feito com a tabela
            	obj[0].table=this.page; //tabela que sera afetada, a mesma que a pagina atual
            	obj=JSON.parse(JSON.stringify(obj).replace("[","").replace("]",""));
            }
            if(this.whatsave==="EditarLogic"){
            	console.dir(obj);
            	obj[0].logica="AdicionarLogic"; //Oque sera feito com a tabela
            	obj[0].table=this.page; //tabela que sera afetada, a mesma que a pagina atual
            	obj=JSON.parse(JSON.stringify(obj).replace("[","").replace("]",""));
            }
            console.log(obj);
            //obj=JSON.parse(obj);
            // $.get("./mvc",obj)
            // {'id':16,'desc_dpto': 'Testao', 'logica': 'AdicionarLogic', 'table': 'Departamentos'}
            $.get("./mvc",obj)
            .error(function(){
            	context.modal.open("Não foi realizar a operação","Tente novamente mais tarde, ou contate o administrador do sistema.",!0,context.modal.refresh)
            })
            .success(function(){
				if(context.whatsave === "AdicionarLogic"){
					context.setRefreshStatus(true);
					context.modal.open("Operação realizada com sucesso","Feche esta janela para continuar",!1,context.modal.refreshBack);
					return !0;
				}
            	else{
            		context.setRefreshStatus(false);
            		context.modal.open("Operação realizada com sucesso","Feche esta janela para continuar",!1,context.modal.refresh)
            	}
            });
            this.reset();
		},

		/*Carrega conteudo do xml nas paginas*/
		loaddata:function(load,obj){
			var context=this;
			if(load !=="list"){
				this.prevent=true;
			}
			else{
				this.prevent=false;
			}
			$.ajax({
	            //verifica se existe o xml para load das paginas
	            type:"GET",
	            url:"load.xml",
	            dataType:"xml",
	            success:function(e){
	                 context.xml=$(e).find("entry");
	                 context.xml.each(function(){
			            if($(this).attr("name")===context.page){
			            	if(obj){
			            		context.whatsave="EditarLogic";
			            		context.contentEl.html($(this).find("cadastro").text());
			            		context.contentEl.fadeIn();
			            		context.insertValues(obj);
			            		context.formAction(context.page);
			            	}
			                else{
			                	context.whatsave="AdicionarLogic";
			                	context.contentEl.html($(this).find(load).text());
			                	context.contentEl.fadeIn();
			                	if(load==="list"){
			                		context.getTableValues();
			                	}
			                	else{
			                		context.formAction(context.page);
			                	}
			                }
			            }
			        });
	            }
		    });
		},

		/*Chamada de metodo java para listar as tabelas na tela*/
		getTableValues:function(){
			var obj,context=this;
			if(this.page === "Visitantes"){
				obj={'logica':'BuscarLogic','table':this.page,'rg':''};
			}
			else{
				obj={'logica':'BuscarLogic','table':this.page};
			}
			$.get("./mvc",obj)
            .error(function(){
            	context.setloading(!1,!0);
            	context.modal.open("Não foi possivel retornar a lista cadastrada","Tente novamente mais tarde, ou contate o administrador do sistema.",!0,!0)
            })
            .success(function(a){
                context.list=JSON.parse(a);
                //console.log(context.list.replace("\"",""));
                console.dir(context.list);
                $("p.count span").text(context.list.length);
                context.writeTable(context.list);
            });
		},

		/*Escreve a tabela de dados na tela*/
		writeTable:function(list){
			var i,length,html="";
			length=list.length;
			switch(this.page){
				case 'Perfis':
					for(i=0;i<list.length;i++){
						html+="<tr><td>"+list[i].id+"</td><td>"+list[i].nome+"</td><td>"+list[i].desc_perfil+"</td><td class='actions'><a href='#"+list[i].id+"' class='delete'></a><a href='#"+list[i].id+"' class='edit'></a></td></tr>";
					}
					break;
				case 'Usuarios':
				//Falta fazer
					for(i=0;i<list.length;i++){
						html+="<tr><td>"+list[i].id+"</td><td>"+list[i].nome+"</td><td>"+list[i].cod_emp.nome_fantasia+"</td><td>"+list[i].cod_depto.desc_dpto+"</td><td class='actions'><a href='#"+list[i].id+"' class='delete'></a><a href='#"+list[i].id+"' class='edit'></a></td></tr>";
					}
					break;
				case 'Feriados':
					for(i=0;i<list.length;i++){
						var data=list[i].data_feriado.toString();
						html+="<tr><td>"+list[i].id+"</td><td>"+list[i].desc_feriado+"</td><td>"+data+"</td><td class='actions'><a href='#"+list[i].id+"' class='delete'></a><a href='#"+list[i].id+"' class='edit'></a></td></tr>";
					}
					break;
				case 'Departamentos':
					for(i=0;i<list.length;i++){
						html+="<tr><td>"+list[i].id+"</td><td>"+list[i].desc_dpto+"</td><td class='actions'><a href='#"+list[i].id+"' class='delete'></a><a href='#"+list[i].id+"' class='edit'></a></td></tr>";
					}
					break;
				case 'Operadores':
					for(i=0;i<list.length;i++){
						html+="<tr><td>"+list[i].id+"</td><td>"+list[i].login.nome_abrev+"</td><td>"+list[i].senha+"</td><td>"+list[i].perfis.desc_perfil+"</td><td class='actions'><a href='#"+list[i].id+"' class='delete'></a><a href='#"+list[i].id+"' class='edit'></a></td></tr>";
					}
					break;
				case 'Empresas':
					for(i=0;i<list.length;i++){
						html+="<tr><td>"+list[i].id+"</td><td>"+list[i].razao_social+"</td><td>"+list[i].nome_fantasia+"</td><td>"+list[i].telefone+"</td><td class='actions'><a href='#"+list[i].id+"' class='delete'></a><a href='#"+list[i].id+"' class='edit'></a></td></tr>";
					}
					break;
				case 'Faixas_Acesso':
					for(i=0;i<list.length;i++){
						html+="<tr><td>"+list[i].id+"</td><td>"+list[i].hora_ini+"</td><td>"+list[i].hora_fim+"</td><td>"+list[i].desc_faixa+"</td><td class='actions'><a href='#"+list[i].id+"' class='delete'></a><a href='#"+list[i].id+"' class='edit'></a></td></tr>";
					}
					break;
				case 'Zonas_Tempo':
				//Falta fazer
					for(i=0;i<list.length;i++){
						html+="<tr><td>"+list[i].id+"</td><td>"+list[i].desc_zona_tempo+"</td><td class='actions'><a href='#"+list[i].id+"' class='delete'></a><a href='#"+list[i].id+"' class='edit'></a></td></tr>";
					}
					break;
				case 'Visitantes':
					for(i=0;i<list.length;i++){
						html+="<tr><td>"+list[i].id+"</td><td>"+list[i].nome+"</td><td>"+list[i].cod_emp.nome_fantasia+"</td><td>"+list[i].num_tel+"</td><td>"+list[i].obs+"</td><td>"+list[i].cod_dpto.desc_dpto+"</td><td class='actions'><a href='#"+list[i].id+"' class='delete'></a><a href='#"+list[i].id+"' class='edit'></a></td></tr>";
					}
					break;
				default:
					html+="Operação não encontrada!";
			}
			$("tbody").html(html);
			this.setloading(!1,!0);
		},

		preventClick:function(a){
			if(this.prevent){
				a.preventDefault();
				this.modal.open("Atenção!!!","Você deve finalizar suas atividades antes de mudar de tela.",!0,!0)
			}
		},


		getRefreshStatus:function(){
			return this.refreshStatus;
		},

		setRefreshStatus:function(status){
			this.refreshStatus=status;
		},
		/*Imprimi página*/
		print:function(a){
			a.preventDefault();
			window.print();
		},

		/*Quando clicado no botão editar. Recebe o valor do objeto clicado e passa para o loaddata joga-los nos inputs*/
		edit:function(a){
			a.preventDefault();
			this.el.addClass("prevent"); //Editing or create data
			var cod=parseInt($(a.target).attr("href").replace("#",""));
			//this.callservice({"codigo":cod},"editar");
			var obj=filterBy(this.list,'id',cod);
			this.editactive=cod;
			this.setloading(!0,!0);
			this.loaddata("cadastro",obj);
		},

		/*Quando clicado no botão deletar*/
		del:function(a){
			a.preventDefault();
			var msg,cod=parseInt($(a.target).attr("href").replace("#",""));
			this.whatsave="DeletarLogic";
			this.setRefreshStatus("Deletar");
			this.modal.codToDelete=cod;
			if(this.page === "Usuarios"){
				msg="Caso deseje realmente deletar, clique em Sim. Se este usuário tiver um login e operador associado, ele também será deletado!"
			}
			else{
				msg="Caso deseje realmente deletar, clique em Sim.";
			}
			this.modal.question("Realmente Deletar?",msg,!0,!0);
			//this.callservice({"id":cod},"DeletarLogic");
		},

		/*Recebe o valor a ser atribuido nos combobox, chama o metodo do formulario que popula o combobox*/
		/*Metodo recebe um obj com o nome da tabela e outro objeto com as especificaçoes*/
		getComboValues:function(obj,link,estado){
			var param,context=this;
			if(estado){
				param={'logica':'BuscarLogic','table':obj.table,'cod_estado':estado};
			}
			else{
				param={'logica':'BuscarLogic','table':obj.table};
			}
			$.get("./mvc",param)
            .error(function(){
            	context.modal.open("Um erro ocorreu!","Tente novamente mais tarde, ou contate o administrador do sistema.",!0,!0)
            })
            .success(function(a){
                context.formulario.popCombo(JSON.parse(a),link);
            });
		},

		/*Ações dos formularios de CADASTRO/EDITAR, como dapicker e camera*/
		formAction:function(){
			var context=this;

			//Executa determinadas ações dependendo da página*/
			$(".bprompt").click(function(e){
				//Ao clicar na seta para baixo do combobox
	            e.preventDefault();
	            if($(this).hasClass("cidade")){
	            	context.getComboValues({"table":"Cidades"},{"pk":"cidade","collum":"cidade","foreign":"cod_cidade"},$("input[name='cod_estado']").val());
	            }
	            context.formulario.toggleSelect($(this),$(this).attr("href").replace("#","."));
	        });
			switch(this.page){
				case 'Perfis':
					
					break;
				case 'Usuarios':
					//context.finishform.fadeOut();
					$('#user a').click(function (e) {
		              e.preventDefault();
		              $(this).tab('show');
		            });

		            $("#initial").trigger("click");
		            $("input[name='tel']").mask("(99) 9999-9999");
		            var date=new Date();
		            var fim = {"input":"input[name='inicio']","whatDate":"maxDate"};
					this.setDatePicker($("input[name='data_nasc']"),null,!1,true,new Date());
					this.setDatePicker($("input[name='val_cartao']"),new Date(),fim,null,null);

					$("#webcamera").webcam({

					    width: 378,
					    height: 278,
					    mode: "callback",
					    swffile: "js/lib/jscam.swf", 
						// canvas only doesn't implement a jpeg encoder, so the file is much smaller

					    onTick: function(remain) {

					        if (0 == remain) {
					            //jQuery("#status").text("Cheese!");
					        } else {
					            //jQuery("#status").text(remain + " seconds remaining...");
					        }
					    },

					    onSave: function(data) {
					        var col = data.split(";");
					    	// Work with the picture. Picture-data is encoded as an array of arrays... Not really nice, though =/
					    },

					    onCapture: function () {
					        webcam.save();
					        console.log("Tirou a foto");
					        context.modal.open("Funcionalidade não disponível!","Esta funcionalidade não está disponível no momento! Será implementada em breve!.",!0,!0);
					      // Show a flash for example
					    },

					    debug: function (type, string) {
					        // Write debug information to console.log() or a div, ...
					        console.log("Ok camera");
					    },

					    onLoad: function () {
					    // Page load
					        var cams = webcam.getCameraList();
					        for(var i in cams) {
					            //$("#cams").append("<li>" + cams[i] + "</li>");
					        }
					    }
					});

					$(".camera").bind("click",function(a){
						//Ao clicar no botão para tirar foto
						console.log("tirou foto");
						a.preventDefault();
						webcam.capture();
					});

					//Combobox
					//TABELA DO BANCO >>  Classe do combo || Nome esperado pela tabela || Nome esperado pela FK, valor vai no combo
					this.getComboValues({"table":"Empresas"},{"pk":"empresa","collum":"nome_fantasia","foreign":"cod_emp"});
					this.getComboValues({"table":"Tipo_Usuario"},{"pk":"tipusuario","collum":"desc_usuario","foreign":"cod_tip"});

					//Fazer
					this.getComboValues({"table":"Estados"},{"pk":"estado","collum":"uf","foreign":"cod_estado"});
					this.getComboValues({"table":"Cidades"},{"pk":"cidade","collum":"cidade","foreign":"cod_cidade"},1);

					this.getComboValues({"table":"Departamentos"},{"pk":"departamento","collum":"desc_dpto","foreign":"cod_depto"});
					this.getComboValues({"table":"Zonas_Tempo"},{"pk":"zonatempo","collum":"desc_zona_tempo","foreign":"cod_zona_tempo"}); //Zonas_Tempo || desc_zona

					break;
				case 'Feriados':
					this.setDatePicker($("input[name='data_feriado']"),new Date(),!1,null,null);
					break;
				case 'Departamentos':
					
					break;
				case 'Operadores':
					this.getComboValues({"table":"Usuarios"},{"pk":"login","collum":"nome","foreign":"login"});
					this.getComboValues({"table":"Perfis"},{"pk":"perfil","collum":"nome","foreign":"cod_perf"});

					break;
				case 'Empresas':
					$("input[name='telefone']").mask("(99) 9999-9999");
					break;
				case 'Faixas_Acesso':
					$("input[name='hora_ini']").mask("99:99:99");
					$("input[name='hora_fim']").mask("99:99:99");
					break;
				case 'Zonas_Tempo':
				//Falta fazer
					this.getComboValues({"table":"Faixas_Acesso"},{"pk":"faixastempo1","collum":"desc_faixa","foreign":"cod_faixa_1"});
					this.getComboValues({"table":"Faixas_Acesso"},{"pk":"faixastempo2","collum":"desc_faixa","foreign":"cod_faixa_2"});
					this.getComboValues({"table":"Faixas_Acesso"},{"pk":"faixastempo3","collum":"desc_faixa","foreign":"cod_faixa_3"});
					break;
				case 'Visitantes':
					$("#webcamera2").webcam({

					    width: 378,
					    height: 278,
					    mode: "callback",
					    swffile: "js/lib/jscam.swf", 
						// canvas only doesn't implement a jpeg encoder, so the file is much smaller

					    onTick: function(remain) {

					        if (0 == remain) {
					            //jQuery("#status").text("Cheese!");
					        } else {
					            //jQuery("#status").text(remain + " seconds remaining...");
					        }
					    },

					    onSave: function(data) {
					        var col = data.split(";");
					    	// Work with the picture. Picture-data is encoded as an array of arrays... Not really nice, though =/
					    },

					    onCapture: function () {
					        webcam.save();
					        console.log("Tirou a foto");
					        context.modal.open("Funcionalidade não disponível!","Esta funcionalidade não está disponível no momento! Será implementada em breve!.",!0,!0);
					      // Show a flash for example
					    },

					    debug: function (type, string) {
					        // Write debug information to console.log() or a div, ...
					        console.log("Ok camera");
					    },

					    onLoad: function () {
					    // Page load
					        var cams = webcam.getCameraList();
					        for(var i in cams) {
					            //$("#cams").append("<li>" + cams[i] + "</li>");
					        }
					    }
					});
	
					$("input[name='num_tel']").mask("(99) 9999-9999");

					$(".camera").bind("click",function(a){
						//Ao clicar no botão para tirar foto
						console.log("tirou foto");
						a.preventDefault();
						webcam.capture();
					});

					$(".search").bind("click",function(e){
						$.get("./mvc",{'logica':'BuscarLogic','table':'Visitantes','rg':$("input[name='rg']").val()})
			            .error(function(){
			            	context.setloading(!1,!0);
			            	//context.modal.open("Não foi possivel retornar a lista cadastrada","Tente novamente mais tarde, ou contate o administrador do sistema.",!0,!0)
			            })
			            .success(function(a){
			            	console.log("SUCESSO RG");
			                context.list=JSON.parse(a);
			                //console.log(context.list.replace("\"",""));
			                console.dir(context.list);
			            });
					});

					this.getComboValues({"table":"Empresas"},{"pk":"empresa","collum":"nome_fantasia","foreign":"cod_emp"});
					this.getComboValues({"table":"Departamentos"},{"pk":"departamento","collum":"desc_dpto","foreign":"cod_dpto"});
					break;
				default:
					html+="Operação não encontrada! Contate o administrador do sistema";
			}
			this.setloading(!1,!0);
		},
		
		setDatePicker:function(input,mindate,closeopt,year,maxDate){
			console.dir(closeopt);
			console.log(closeopt.input);
			input.datepicker({
				changeMonth: true,
				numberOfMonths: 2,
				changeYear: year,
				monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
			    monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
			    dayNamesMin: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
			    dateFormat:"yy/mm/dd",
			    minDate:mindate,
			    maxDate:maxDate,
			    onClose: function( selectedDate ) {
			    	//{"input":"input[name='fim']","whatDate":"minDate"}
			    	if(closeopt){
			    		console.log("option", closeopt.whatDate);
			    		console.dir(selectedDate);
			    		//$( "input[name='start']").datepicker( "option", "maxDate", selectedDate );
			    		$(closeopt.input).datepicker( "option", closeopt.whatDate , selectedDate)
			    	}
			    }
			});
			input.keypress(function(e){
				console.dir(e);
				e.preventDefault();
			});
		},
		/*Quando clicado no botão enviar do formulário*/
		submitform:function(a){
			a.preventDefault();
			var complet,i,length,context=this,obj="[{";
			var cinputs=$("input");
			length=cinputs.length;
			
			if(this.editactive){
				obj+='"id":'+this.editactive+",";
			}
			cinputs.removeClass("error-border");
			cinputs.each(function(index){
				if($(this).attr("required")){
					if(!$(this).val() || $(this).val() === $(this).attr("placeholder")){
						$(this).addClass("error-border");
						return !1;
					}
				}
				obj=obj.concat('"'+$(this).attr("name")+'":"'+$(this).val()+'"');
				if((index+1)<length){
					obj+=",";
				}
				//complet=!1;
				if((index+1)>=length){
					obj+="}]";
					console.log(obj);
					obj=JSON.parse(obj);
					console.dir(obj);
					context.callservice(obj,context.whatsave);
				}
				//$(this).val(obj[0][$(this).attr("name")]);
			});
		},

		/*Inseri os valores nos inputs*/
		insertValues:function(obj){
			console.log("INSERI");
			console.dir(obj);
			var cinputs=$("input");
			cinputs.each(function(){
				$(this).val(obj[0][$(this).attr("name")]);
			});
			this.setloading(!1,!0);
			//console.dir(obj);
		},

		/**
		*	Cancel Button
		*
		*	This method cancel all editions and return to a previews page
		*	Before redirect a previews page the method open modal question, and if the user click 'yes' it will be redirected
		**/
		cancel: function(a) {
			if("object" === typeof a) {
		      a.preventDefault();
		    }
			if (this.loading) {
				return false;
			}
			if(this.whatsave === "EditarLogic"){
				this.setRefreshStatus(true);
			}
			else{
				this.setRefreshStatus(false);
			}
			this.modal.question("Retornar?", "Suas alterações serão desfeitas!", !0, !0);
		},

		/**
		*	Set the loading state
		*
		*	@param {Boolean} a. If true show mask, else hide mask.
		*	@param {Boolean} b. If is false, open the loader, else open just the mask div
		*
		*	This method set the state loader
		*/

		setloading: function(a, b) {
			if (!b) {
				if (a) {
					this.maskEl.fadeIn();
					this.loading = !0;
				} else {
					this.maskEl.fadeOut();
					this.loading = !1;
				}
			} else {
				if (a) {
					this.loader.fadeOut();
					this.maskEl.fadeIn();
					this.loading = !0;
				} else {
					this.maskEl.fadeOut();
					this.loader.fadeIn();
					this.loading = !1;
				}
			}
			return this.loading;
		},

		/**
		*	Return the loading state
		*/
		getloading:function(){
			return this.loading;
		},

		logout:function(a) {
	    	a && a.preventDefault();
	    	//$.removeCookie("app", {path:"/"});
	    	window.location = "sair.jsp";
	  	},

		/**
		*	Reseting the application
		*/
		reset: function(nothome) {
			this.editactive=0;
		}
	});
	new App; //Creates application
	Spine.Route.setup(); //Enables @route
});