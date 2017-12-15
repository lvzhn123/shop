$(function(){
		var aLi = $('.list1 li');
		var leng = aLi.length;
		var arr = ['很差','较差','一般','较好','很好'];
		var arr2 = ['images/star-off-big.png','images/star-off-big.png','images/star-off-big.png','images/star-off-big.png','images/star-off-big.png'];
		var s1 = '';

		aLi.click(function(){
			var i = $(this).index();
			if(i < 2){
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					s1 = arr[i];
					arr2[j] = aLi.eq(j).find('img').attr('src');
				}
			}else{
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					s1 = arr[i];
					arr2[j] = aLi.eq(j).find('img').attr('src');
				}
			};

			for(var k = i+1; k<leng; k++){
				arr2[k] = 'images/star-off-big.png';
			};
			$('.s1').text(s1);
		});

		aLi.hover(function(){
			for(var j=0; j<leng; j++){
				aLi.eq(j).find('img').attr('src','images/star-off-big.png');
			};
			var i = $(this).index();
			if(i < 2){
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					$('.s1').text(arr[i]);
				}
			}else{
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					$('.s1').text(arr[i]);
				}
			}
		},function(){
			for(var i = 0; i<leng; i++){
				aLi.eq(i).find('img').attr('src',arr2[i]);
			}
			$('.s1').text(s1);
		});

	})



	$(function(){
		var aLi = $('.list2 li');
		var leng = aLi.length;
		var arr = ['很差','较差','一般','较好','很好'];
		var arr2 = ['images/star-off-big.png','images/star-off-big.png','images/star-off-big.png','images/star-off-big.png','images/star-off-big.png'];
		var s1 = '';

		aLi.click(function(){
			var i = $(this).index();
			if(i < 2){
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					s1 = arr[i];
					arr2[j] = aLi.eq(j).find('img').attr('src');
				}
			}else{
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					s1 = arr[i];
					arr2[j] = aLi.eq(j).find('img').attr('src');
				}
			};

			for(var k = i+1; k<leng; k++){
				arr2[k] = 'images/star-off-big.png';
			};
			$('.s2').text(s1);
		});

		aLi.hover(function(){
			for(var j=0; j<leng; j++){
				aLi.eq(j).find('img').attr('src','images/star-off-big.png');
			};
			var i = $(this).index();
			if(i < 2){
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					$('.s2').text(arr[i]);
				}
			}else{
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					$('.s2').text(arr[i]);
				}
			}
		},function(){
			for(var i = 0; i<leng; i++){
				aLi.eq(i).find('img').attr('src',arr2[i]);
			}
			$('.s2').text(s1);
		});

	})


	$(function(){
		var aLi = $('.list3 li');
		var leng = aLi.length;
		var arr = ['很差','较差','一般','较好','很好'];
		var arr2 = ['images/star-off-big.png','images/star-off-big.png','images/star-off-big.png','images/star-off-big.png','images/star-off-big.png'];
		var s1 = '';

		aLi.click(function(){
			var i = $(this).index();
			if(i < 2){
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					s1 = arr[i];
					arr2[j] = aLi.eq(j).find('img').attr('src');
				}
			}else{
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					s1 = arr[i];
					arr2[j] = aLi.eq(j).find('img').attr('src');
				}
			};

			for(var k = i+1; k<leng; k++){
				arr2[k] = 'images/star-off-big.png';
			};
			$('.s3').text(s1);
		});

		aLi.hover(function(){
			for(var j=0; j<leng; j++){
				aLi.eq(j).find('img').attr('src','images/star-off-big.png');
			};
			var i = $(this).index();
			if(i < 2){
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					$('.s3').text(arr[i]);
				}
			}else{
				for(var j=0; j<=i; j++){
					aLi.eq(j).find('img').attr('src','images/star-on-big.png');
					$('.s3').text(arr[i]);
				}
			}
		},function(){
			for(var i = 0; i<leng; i++){
				aLi.eq(i).find('img').attr('src',arr2[i]);
			}
			$('.s3').text(s1);
		});

	})