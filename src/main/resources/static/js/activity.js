$(function () {
    $(".header-navgation .activity").addClass("active"), $(".animateGif").removeClass("hidden"), setTimeout(function () {
        $.post(module + "/sapi/showNewStore", function (i) {
            var a = i, s = "";
            for (var t in a) s += '<div class="citiesStroe"><div class="storeInfo"><h1>' + a[t].SN_Title + "</h1><p>" + a[t].SN_Describe + '</p><div class="map"><a href="javascript:;" data-class="' + a[t].SN_City + '">查看地图<span class="glyphicon glyphicon-play"></span></a></div></div><div class="storePic"><img src="' + a[t].SN_Photo + '" alt="海马体照相馆"></div></div>';
            $("#activity").html(s), $("#activity .map").on("click", function () {
                var i = "";
                i = $(this).find("a").data("class"), window.open(module + "/Index//map?city=" + i)
            }), $(".animateGif").addClass("hidden")
        })
    }, 1e3)
});