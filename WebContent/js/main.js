$(function(){

	/*������ �����*/
	$("#mainVisual>.visual").each(function(i){
		$(this).data("index", i);
	});

	$("#mainVisual").cycle({
		fx: "fadeout",
		speed:300,
		timeout: 4000,
		delay: 0,
		slideExpr : ">p",
		before: visualBefore,
		next: '#next',
		prev: '#prev'
	});

	/*�̺�Ʈ �Ѹ�*/
	$("#event>.event").each(function(i){
		$(this).data("index", i);
	});

	$("#event").cycle({
		fx: "fadeout",
		speed:800,
		timeout: 4000,
		delay: 0,
		slideExpr : ">p",
		before: visualBefore2
	});

	/*���̾��˾� �Ѹ�*/
	$("#layer>.layer").each(function(i){
		$(this).data("index", i);
	});

	$("#layer").cycle({
		fx: "fadeout",
		speed:800,
		timeout: 4000,
		delay: 0,
		slideExpr : ">p",
		before: visualBefore3
	});
	
	
	//rollingTxt(); // NOTICE , ��÷�ڹ�ǥ
});

/* ����� control */
function visualBefore(){
	var idx = parseInt($(this).data("index"));
	$("#mainVisual>a").removeClass("active");
	$("#mainVisual>a:eq("+idx+")").addClass("active");
	$("#mainVisual>.page").click(function(){return false});
}
function thisArea(n) {
	$("#mainVisual").cycle(n-1);
	$("#mainVisual").cycle("pause");
	$("#visual-wrap .pause").removeClass('on');
	$("#visual-wrap .play").addClass('on')
}
function resume() {
	$("#mainVisual").cycle("resume");
	$("#visual-wrap .play").removeClass('on');
	$("#visual-wrap .pause").addClass('on');
}
function pause() {
	$("#mainVisual").cycle("pause");
	$("#visual-wrap .pause ").removeClass('on');
	$("#visual-wrap .play").addClass('on');
}

/* �̺�Ʈ control*/
function visualBefore2(){
	var idx = parseInt($(this).data("index"));
	$("#event>a").removeClass("active");
	$("#event>a:eq("+idx+")").addClass("active");
	$("#event>.page").click(function(){return false});
}
function thisArea2(n) {
	$("#event").cycle(n-1);
	$("#event").cycle("pause");
	$("#event-wrap .pause").removeClass('on');
	$("#event-wrap .play").addClass('on');
}
function resume2() {
	$("#event").cycle("resume");
	$("#event-wrap .play").removeClass('on');
	$("#event-wrap .pause").addClass('on');
}
function pause2() {
	$("#event").cycle("pause");
	$("#event-wrap .pause").removeClass('on');
	$("#event-wrap .play").addClass('on');
}

/* ���̾��˾� control*/
function visualBefore3(){
	var idx = parseInt($(this).data("index"));
	$("#layer>a").removeClass("active");
	$("#layer>a:eq("+idx+")").addClass("active");
	$("#layer>.page").click(function(){return false});
}
function thisArea3(n) {
	$("#layer").cycle(n-1);
	$("#layer").cycle("pause");
	$("#layerPop .pause").removeClass('on');
	$("#layerPop .play").addClass('on');
}
function resume3() {
	$("#layer").cycle("resume");
	$("#layerPop .play").removeClass('on');
	$("#layerPop .pause").addClass('on');
}
function pause3() {
	$("#layer").cycle("pause");
	$("#layerPop .pause").removeClass('on');
	$("#layerPop .play").addClass('on');
}


/* NOTICE , ��÷�ڹ�ǥ */
function rollingTxt(){
	
	var obj1 = $('#notice ul');
	var obj2 = $('#winner ul');
	var rHeight = $('#notice ul li').height();
	var rTime = 5000;
	var countN = 0;
	var countW = 0;
	

	$('#notice .controller a').eq(0).click(function(){
		if($('#notice ul').find('li').length > 1){
			countN--;
			if(countN == -1){
				countN = obj1.find('li').length-1;
			}
			obj1.css("margin-top" , -(rHeight * (countN)) + "px");
		}

		return false;
	});
	
	
	$('#notice .controller a').eq(1).click(function(){
		if($('#notice ul').find('li').length > 1){
			countN++;
			if(countN >=  obj1.find('li').length){
				countN = 0;
			}
			obj1.css("margin-top" , -(rHeight * (countN)) + "px");
		}

		return false;
	});
	
	function play1(){
		playStart1 = setInterval(function(){
			$('#notice .controller a').eq(1).click();
		}, rTime);
	}
	
	if($('#notice ul').find('li').length > 1){
		play1();
	}
	$('#notice').hover(function(){
		clearInterval(playStart1);
	}, function(){
		if($('#notice ul').find('li').length > 1){
			play1();
		}
	});
	
	$('#notice a').focus(function(){
		clearInterval(playStart1);
	});
	$('#notice a').blur(function(){
		if($('#notice ul').find('li').length > 1){
			play1();
		}
	});
	
	
}

