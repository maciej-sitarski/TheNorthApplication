google.charts.load('current', {'packages': ['corechart']});
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    const id = isMaskNeeded = document.getElementById('idShop').value;
    $.getJSON('/rest/api/store/'+id, function (dataset1) {

        let answersAndPercentsArrayChart1 = [['Status', 'Percent',],];

        console.log(dataset1);
        let yesAnswers = dataset1.statisticDto.queueSize*20;
        let noAnswers = 100-yesAnswers;

        let yesPercentArray = ['Tak', yesAnswers];
        let noPercentArray = ['Nie', noAnswers];

        answersAndPercentsArrayChart1.push(yesPercentArray);
        answersAndPercentsArrayChart1.push(noPercentArray);

        var options = {
            legend: 'none',
            backgroundColor: "#d1efe7",
            chartArea: {width:'100%',height:'100%'},
            fontSize:40,
            slices: {
                0: { color: '#ff5757' },
                1: { color: '#8ade70' }
            }
        };
        let dataChart1 = google.visualization.arrayToDataTable(
            answersAndPercentsArrayChart1);

        let chart1 = new google.visualization.PieChart(
            document.getElementById('piechart1'));

        chart1.draw(dataChart1, options);
    });
}

$(window).resize(function(){
    drawChart();
});
