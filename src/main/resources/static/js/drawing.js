var myChart = echarts.init(document.getElementById('main'));
// 显示标题，图例和空的坐标轴
myChart.setOption({
    title: {
        text: 'AUC-KS曲线'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['auc', 'ks']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    // xAxis: {
    // data: []
    // },
    xAxis: {
        boundaryGap: false,
        data: ['一折', '二折', '三折', '四折', '五折', '六折', '七折', '八折', '九折', '十折']
    },
    yAxis: {},
    series: [{
        name: 'auc',
        type: 'line',
        smooth: true,
        data: [],
    },
    {
        name: 'ks',
        type: 'line',
        smooth: true,
        data: []
    }]
});
setInterval(function() {
    update_data()
},
1000);

// 异步加载数据
function update_data() {
	$.get('/read').done(function (data) {
	    // 填入数据
	    data = JSON.parse(data);
	    if (data != null) {
	    		if (data.auc.length == 10) {
	    			$("#train_btn").text("训练");
	    			removeAttr("disabled")
	    			$('#train_btn').removeAttr("disabled");
	    		} else {
	    			$("#train_btn").text("正在训练");
	    		}
	    		
	           
        } else {
        	myChart.showLoading();
        }
	    myChart.setOption({
	        series: [{
	            name: 'auc',
	            type: 'line',
	            data: data.auc
	        }, {
	            name: 'ks',
	            type: 'line',
	            data: data.ks
	        }, ]
	    });

	});
}