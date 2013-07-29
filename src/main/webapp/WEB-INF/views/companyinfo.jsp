<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=utf-8">
        <title>My first stock chart</title>
         <script type="text/javascript">
  	  		<%@ include file="amstock.js" %>
  		  </script>
  		      <link rel="stylesheet" type="text/css" href="style.css" />
  		  
    </head>
    <body>        
    You requested quote for ${model.companySymbol}
   
<div id="financeID">
</div>
	           <script type="text/javascript">
		     	var chartData = [];
		     	var tempData = [];

				var currentDateInGraph = new Date(2013, 5,6);
				var currentPrice = 111;
	           </script>
<c:choose>
	<c:when test="${model.historicalQuotes != null}">
	   <c:forEach items="${model.historicalQuotes}" var="item">
	           <script type="text/javascript">
	       	    var currentDate = '${item.day}';
	       	    var currentMonth = '${item.month}';
	       	    var currentYear = '${item.year}';
				var currentPrice = ' ${item.price}';
			// currentPrice = 	 Math.round(Math.random() * (40 + 2)) + 100 + 2;

					 currentDateInGraph = new Date(currentYear,currentMonth,currentDate);
					 currentDateInGraph.setHours(0, 0, 0, 0);

				tempData.push({

					date: currentDateInGraph,
					value: currentPrice
				});  

	           </script>
	   </c:forEach>
	</c:when>
</c:choose>

    <div id="chartdiv" style="width:100%; height:400px;"></div>
    <script type="text/javascript">
    
    AmCharts.ready(function () {
		generateChartData();
		createStockChart();
	});


	function generateChartData() {
		var firstDate = new Date(2012, 0, 1);
		firstDate.setDate(firstDate.getDate() - 500);
		firstDate.setHours(0, 0, 0, 0);

		for (var i = 0; i < 5; i++) {
			var newDate = new Date(firstDate);
			newDate.setDate(newDate.getDate() + (++i));

			var value = Math.round(Math.random() * (40 + i)) + 100 + i;

			/* chartData.push({
				date: newDate,
				value: value
			}); */
		}
		for(var j=tempData.length-1 ; j>-1;j--){
			chartData.push({
				date: tempData[j]["date"],
				value:tempData[j]["value"]
			});		
		}
		/* chartData.push({
			date: currentDateInGraph,
			value: currentPrice
		}); */
	}


	function createStockChart() {
		var chart = new AmCharts.AmStockChart();
		chart.pathToImages = "/images/";

		// DATASETS //////////////////////////////////////////
		var dataSet = new AmCharts.DataSet();
		dataSet.color = "#b0de09";
		dataSet.fieldMappings = [{
			fromField: "value",
			toField: "value"
		}];
		dataSet.dataProvider = chartData;
		dataSet.categoryField = "date";

		chart.dataSets = [dataSet];

		// PANELS ///////////////////////////////////////////                                                  
		var stockPanel = new AmCharts.StockPanel();
		stockPanel.showCategoryAxis = true;
		stockPanel.title = "Value";
		stockPanel.eraseAll = false;
		stockPanel.addLabel(0, 100, "", "center", 16);

		var graph = new AmCharts.StockGraph();
		graph.valueField = "value";
		graph.bullet = "round";
		stockPanel.addStockGraph(graph);

		var stockLegend = new AmCharts.StockLegend();
		stockLegend.valueTextRegular = " ";
		stockLegend.markerType = "none";
		stockPanel.stockLegend = stockLegend;
		stockPanel.drawingIconsEnabled = true;

		chart.panels = [stockPanel];


		// OTHER SETTINGS ////////////////////////////////////
		var scrollbarSettings = new AmCharts.ChartScrollbarSettings();
		scrollbarSettings.graph = graph;
		scrollbarSettings.updateOnReleaseOnly = true;
		chart.chartScrollbarSettings = scrollbarSettings;

		var cursorSettings = new AmCharts.ChartCursorSettings();
		cursorSettings.valueBalloonsEnabled = true;
		chart.chartCursorSettings = cursorSettings;


		// PERIOD SELECTOR ///////////////////////////////////
		var periodSelector = new AmCharts.PeriodSelector();
		periodSelector.position = "bottom";
		periodSelector.periods = [{
			period: "DD",
			count: 10,
			label: "10 days"
		}, {
			period: "MM",
			count: 1,
			label: "1 month"
		}, {
			period: "YYYY",
			count: 1,
			label: "1 year"
		}, {
			period: "YTD",
			label: "YTD"
		}, {
			period: "MAX",
			label: "MAX"
		}];
		chart.periodSelector = periodSelector;

		var panelsSettings = new AmCharts.PanelsSettings();
		chart.panelsSettings = panelsSettings;

		chart.write('chartdiv');
	}

        </script> 

    </body>
</html>