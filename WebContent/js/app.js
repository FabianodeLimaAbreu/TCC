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
			
		},
		events: {
			
		},
		init: function() {
			mobilecheck() && $(document.body).addClass("mobile");
			this.loading = !1;
			this.page = "home";
			this.usr = jQuery.parseJSON($.cookie("portal"));
			if (!this.usr) {
				return this.logout(), !1;
			}
			//this.userTx.text(this.usr.Nome.capitalize());
			this.el.find("#wrap").removeClass("hide");
			this.content = new Content({
				
			});
			this.routes({
				"": function() {
					
				}
			});
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
	$(window).bind("orientationchange", function(a, c) {
		var d = null != navigator.userAgent.match(/iPad/i);
		d && c && 90 != Math.abs(window.orientation) || d && 90 != Math.abs(window.orientation) ? $(document.body).addClass("portrait") : $(document.body).removeClass("portrait");
	});
	$(window).trigger("orientationchange", !0);
});