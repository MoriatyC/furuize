var myChart = echarts.init(document.getElementById('main'));
// 显示标题，图例和空的坐标轴
myChart.setOption({
    title: {
        text: 'KS曲线'
    },
    tooltip: {},
    legend: {
        data:['value']
    },
    xAxis: {
        data: []
    },
    yAxis: {},
    series: [{
        name: 'value',
        type: 'line',
        smooth: true,
        data: []
    }]
});

setInterval(function(){update_data()}, 1000);

// 异步加载数据
function update_data() {
	$.get('/read').done(function (data) {
	    // 填入数据
		data = JSON.parse(data);
		console
	    myChart.setOption({
	        xAxis: {
	            data: data.categories
	        },
	        series: [{
	        	data: data.data

	        }]
	    });
	});
}
