function like() {
    var e = $(this).attr("id"), i = e.split("like"), t = i[1], a = parseInt($("#likeCount" + t).html()),
        o = $(this).attr("rel");
    "like" === o ? ($("#likeCount" + t).html(a + 1), $(this).addClass("changeHeart").attr("rel", "unlike")) : ($("#likeCount" + t).html(a - 1), $(this).removeClass("changeHeart").attr("rel", "like")), event.stopPropagation()
}

function workNav() {
    $(".navModel ul a").hover(function () {
        var e = $(this).position().left, i = $(this).outerWidth(), t = $(this).data("class");
        "全部产品" !== t && $(".nav-ClassStyle a").css({left: e, width: i}).html(t).show(200)
    }, function () {
        $(".nav-ClassStyle a").hide()
    })
}

function seeBigPic() {
    var e = function (e, i, t) {
        this.src = e.split("!")[0], this.text = i, this.node = "", this.target = t, this.nextTarget = "", this.prevTarget = ""
    };
    e.prototype.init = function () {
        this.createModel(), this.bindEvent(this.target)
    }, e.prototype.prev = function () {
    }, e.prototype.next = function () {
    }, e.prototype.bindEvent = function (e) {
        var i = $(e);
        $(".prevArrow").bind("click", function () {
            var e, t;
            i.prev().find("img").attr("src") ? (e = i.prev().find("img").attr("src").split("!")[0] + "", t = i.prev().find(".wenzi h5").text() + "  (" + i.prev().find(".theme").text() + ")", $(".imageModel").find("img").attr("src", e), $(".imageModel").find(".tipModel p").text(t), i = $(i.prev()), $(".loadingTip").hide()) : ($(".tipAlert").removeClass("hidden"), $(".tipAlert").text("当前已是第一张"), setTimeout("$('.tipAlert').addClass('hidden')", 1e3))
        }), $(".nextArrow").bind("click", function () {
            var e, t;
            i.next().find("img").attr("src") ? (e = i.next().find("img").attr("src").split("!")[0] + "", t = i.next().find(".wenzi h5").text() + "  (" + i.next().find(".theme").text() + ")", $(".imageModel").find("img").attr("src", e), $(".imageModel").find(".tipModel p").text(t), i = $(i.next()), $(".loadingTip").hide()) : ($(".tipAlert").removeClass("hidden"), $(".tipAlert").text("当前已是最后一张"), setTimeout("$('.tipAlert').addClass('hidden')", 1e3))
        })
    }, e.prototype.createModel = function () {
        $(".imageModel").remove(), this.node = ['<div class="imageModel">', '<div class="globalMask"></div>', '<div class="imageBlock">', '<div class="imageWrap">', '<img src="' + this.src + '" alt="拾光秀照相馆" class="imageNode" style="position:absolute;left:-9999px;" >', '<div class="loadingTip"></div>', "</div>", '<div class="arrowModel">', '<a href="javascript:;" class="prevArrow" ></a>', '<a href="javascript:;" class="nextArrow" ></a>', "</div>", '<div class="tipModel">', "<p>" + this.text + "</p>", "</div>", '<a href="javascript:;" class="closeModel"></a>', '<div class="tipAlert hidden"></div>', "</div>", "</div>"].join(""), $(this.node).appendTo($(document.body)), $(".imageModel img").on("load", function () {
            var e = $(this), i = e.height(), t = e.width();
            $(".imageBlock").css({
                marginTop: -(i / 2),
                marginLeft: -(t / 2),
                opacity: 1
            }), $(".imageWrap").animate({width: t, height: i}, function () {
                e.css("position", "static"), $(".loadingTip").hide()
            })
        })
    }, e.prototype.removeModel = function () {
        $(".closeModel").on("click", function () {
            $(".imageModel").remove()
        }), $(document).on("click", ".globalMask", function () {
            $(".imageModel").remove()
        })
    }, $(".flowPic").on("click", "img", function () {
        var i = $(this).parent(), t = $(this).attr("src"),
            a = i.find(".wenzi h5").text() + "&nbsp;&nbsp;(" + i.find(".theme").text() + ")", o = new e(t, a, i);
        o.init(), o.removeModel()
    })
}

function navActive(e) {
    for (var i = $(".navModel li"), t = 0; t < i.length; t++) $(i[t]).children().data("id") == e && $(i[t]).addClass("fontBigger")
}

$(function () {
    $(".header-navgation .works").addClass("active"), $(".to-top").click(function () {
        return $("body,html").animate({scrollTop: 0}, 500), !1
    }),
        $.post("/category/list",
            function (e) {
        var i = e.data, t = "", a = "", o = "", n = "";
        if ("0" == e.code) {
            a = '<ul><li><a data-class="全部产品" data-id="0">全 部</a></li>';
            for (var d in i) "8" !== i[d].P_Id && "14" !== i[d].id && "16" !== i[d].id && "17" !== i[d].id && "18" !== i[d].id && "19" !== i[d].id && "22" !== i[d].id && "23" !== i[d].id && "24" !== i[d].id && (o += '<li><a href="javascript:;" data-id="' + i[d].id + '" data-class="' + i[d].name + '">' + i[d].name + "</a></li>");
            n = '</ul><div class="nav-ClassStyle"><a href="javascript:;" style="display:none;">全年主打</a></div>', t = a + o + n, $(".navModel").html(t);
            var r = window.location.href;
            if (r.split("?")[1]) {
                var s = parseInt(r.split("?")[1].split("=")[1]);
                navActive(s), fuildImg({id: s, page: 1, eventType: "click"})
            } else navActive(0), fuildImg({id: 0, page: 1, eventType: "click"});
            workNav(), $(".navModel ul a").on("click", function () {
                $(this).parent().siblings("li").removeClass("fontBigger"), $(this).parent().addClass("fontBigger");
                var e = $(this).data("id"), i = {};
                i.product = e, fuildImg({id: e, page: 1, eventType: "click"})
            });
            var l = !0;
            $(window).scroll(function () {
                $(window).scrollTop() > 300 ? $(".backTop").fadeIn(500) : $(".backTop").fadeOut(500), $(document).height() - $(window).height() - $(document).scrollTop() <= 0 && (l && (fuildImg({eventType: "scroll"}), l = !l), setTimeout(function () {
                    l = !0
                }, 200))
            })
        }
    },"json")
});
var fuildImg = function () {
    var e = {id: 0, page: 1, pageSize: 15, eventType: "", nodeText: "", nodeContainer: "#masonry"};
    return function (i) {
        if (i && "[object Object]" === Object.prototype.toString.call(i)) for (var t in i) e[t] = i[t];
        var a = {
            init: function () {
                a.createNode()
            }, createNode: function () {
                "scroll" === e.eventType && e.page++;
                var i = {category_id: e.id, page: e.page, pageSize: e.pageSize};
                $(".loadingTip").show(),
                    $.post("/categoryimage/list",i, function (i) {
                    var t = i.list;
                    if (t&&t.length>0) {
                        var o = "";
                        if (null == t) return $(".loadingTip").hide(), $(".loaded").fadeIn(), setTimeout(function () {
                            $(".loaded").fadeOut()
                        }, 2e3), !1;
                        for (var n in t) o += '<div class="flowPic" data-category="' + "照片" + '"><img src="' + t[n].url +'" alt=""><div class="wenzi-wrap"><div class="wenzi"><h5>' + "照片"+ '</h5><span class="theme">' + '照片' + '</span><div class="like"><a href="javascript:;" class="heart" id="like' + t[n].id + '" rel="like"></a><em id="likeCount' + t[n].id + '">' + "照片" + "</em></div></div></div></div>";
                        e.textNode = o, a.updateView(e.eventType)
                    }
                },"json")
            }, updateView: function (i) {
                var t = $("#masonry").masonry({
                    itemSelector: ".flowPic",
                    isFitWidth: !0,
                    transitionDuration: "1s",
                    columnWidth: 50
                });
                switch (i) {
                    case"click":
                        var a = $(".flowPic");
                        t.masonry("remove", a);
                        var o = $(e.textNode);
                        o.imagesLoaded(function () {
                            $("#masonry").append(o).masonry("appended", o);
                            $("#masonry").masonry({
                                itemSelector: ".flowPic",
                                isFitWidth: !0,
                                transitionDuration: "1s",
                                columnWidth: 50
                            });
                            seeBigPic(), $(".heart").off("click").bind("click", function (e) {
                                e.stopPropagation(), like.apply(this)
                            }), $(".loadingTip").hide()
                        });
                        break;
                    case"scroll":
                        var o = $(e.textNode);
                        o.imagesLoaded(function () {
                            t.append(o).masonry("appended", o), seeBigPic(), $(".heart").off("click").bind("click", function (e) {
                                e.stopPropagation(), like.apply(this)
                            }), $(".loadingTip").hide()
                        });
                        break;
                    default:
                        alert("请填写事件类型")
                }
            }
        };
        return a.init()
    }
}();