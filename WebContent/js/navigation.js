$(document).ready(function () {
	CAMPING.gnbOver();
	CAMPING.subGnb();
	CAMPING.lnbOver();
	CAMPING.topNenu();
});

var CAMPING = {
	mainLink: function () {
		location.href = '/';
	},
	subGnb: function () {
		var mypage = $('#header .nav_sub_mypage'),
			link = mypage.find('> a'),
			mypage_box = mypage.find('.mypage_box');
			
		link.add(mypage_box).hover(
			function () {
				mypage_box.show();
			},
			function () {
				mypage_box.hide();
			}
		);
	},
	gnbOver: function () {
		var gnb = $('#gnb'),
			menus = gnb.find('a');
			
		menus.hover(
			function () {
				if($(this).hasClass('gnb_active')) {return false;}
				CAMPING.menuOnOff($(this), '.gif', '_on.gif');
			},
			function () {
				if($(this).hasClass('gnb_active')) {return false;}
				CAMPING.menuOnOff($(this), '_on.gif', '.gif');
			}
		);
	},
	gnbActive: function (idx) {
		var gnb = $('#gnb a').eq(idx - 1);
		gnb.addClass('gnb_active');
		CAMPING.menuOnOff(gnb, '.gif', '_on.gif');
	},
	menuOnOff: function (obj, replaceTxt, newTxt) {
		var img = obj.find('img');
		img.attr('src', img.attr('src')
			.replace(replaceTxt, newTxt))
			.css({'opacity':'.5'})
			.stop().animate({'opacity':'1'});
	},
	lnbActive: function (depth1, depth2) {
		var lnb = $('#lnb dl').eq((depth1 == '5' ? 4 : depth1) - 1).find('a').eq(depth2 - 1);
		lnb.addClass('lnb_active');
		CAMPING.menuOnOff(lnb, '.gif', '_on.gif');
	},
	lnbOver: function () {
		var lnb = $('#lnb'),
			menus = lnb.find('a');
			
		menus.hover(
			function () {
				if($(this).hasClass('lnb_active')) {return false;}
				CAMPING.menuOnOff($(this), '.gif', '_on.gif');
			},
			function () {
				if($(this).hasClass('lnb_active')) {return false;}
				CAMPING.menuOnOff($(this), '_on.gif', '.gif');
			}
		);
	},
	topNenu: function () {
		var top = $('#top'),
			ct = parseInt(top.css('top'));
		
		$(window).scroll(function () {
			var wt = $(window).scrollTop();
			top.stop().animate({top: ct + wt + 'px'}, 800);
		});
	}

};