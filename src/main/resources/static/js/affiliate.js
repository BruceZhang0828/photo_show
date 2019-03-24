function appMaskLayer() {
    $(".applyMaskLayer").on("click", function () {
        $(".applyModel").hide()
    })
}

function tipDialog(t, e, i) {
    var n, o, a = '<div class="tipMsg"><p>' + t + "</p>", p = $(e).width(), s = $(e).height(),
        r = $(a).appendTo($(e)).width(), c = $(a).appendTo($(e)).height();
    return n = p > r ? (p - r) / 2 : 0, o = s > c ? (s - c) / 2 : 0, $(".tipMsg").css({left: n, top: o}), function (t) {
        i && setTimeout(t, i)
    }
}

$(function () {
    $(".header-navgation .affiliate").addClass("active");
    var t = {
        isEmpty: function (t, e) {
            return t ? void 0 : e
        }, minLength: function (t, e, i) {
            return t.length < e ? i : void 0
        }, isPhone: function (t, e) {
            return /(^1[3|5|8|9][0-9]{9}$)/.test(t) ? void 0 : e
        }, province: function (t, e) {
            return "省份" == t ? e : void 0
        }, city: function (t, e) {
            return "地级市" == t ? e : void 0
        }
    }, e = function () {
        this.cache = []
    };
    e.prototype.start = function () {
        for (var t = 0, e = this.cache.length; e > t; t++) {
            var i = this.cache[t]();
            if (i) return i
        }
    }, e.prototype.add = function (e, i) {
        for (var n = this, o = 0; o < i.length; o++) {
            var a = i[o];
            !function (i) {
                var o = i.method.split(":"), a = i.tipMsg;
                n.cache.push(function () {
                    var i = o.shift();
                    return o.unshift(e.val()), o.push(a), t[i].apply(e, o)
                })
            }(a)
        }
    };
    var i = function () {
        var t = new e;
        t.add($("#name"), [{method: "isEmpty", tipMsg: "用户名不能为空"}]), t.add($("#email"), [{
            method: "isEmpty",
            tipMsg: "邮箱不能为空"
        }]), t.add($("#phone"), [{method: "isEmpty", tipMsg: "电话不能为空"}, {
            method: "isPhone",
            tipMsg: "电话号码格式不正确"
        }]), t.add($("#s_province option:selected"), [{
            method: "province",
            tipMsg: "请选择合作省份"
        }]), t.add($("#s_city option:selected"), [{
            method: "city",
            tipMsg: "请选择合作地级市"
        }]), t.add($(".career"), [{
            method: "isEmpty",
            tipMsg: "目前从事职业不能为空"
        }]), t.add($(".messages"), [{method: "isEmpty", tipMsg: "给我们的留言不能为空"}]);
        var i = t.start();
        return i ? i : void 0
    };
    $(".onlineBtn").on("click", function () {
        $(".applyModel").show(), _init_area(), appMaskLayer(), $(".applyBtn button").on("click", function () {
            var t = i();
            if (t) {
                var e = tipDialog(t, $(".applyWrap"), 1500);
                e(function () {
                    $(".tipMsg").remove()
                })
            } else {
                var n = $("#name").val(), o = $("#phone").val(), a = $("#s_province option:selected").val(),
                    p = $("#s_city option:selected").val(), s = $(".career").val(), r = $(".messages").val(),
                    c = $("#email").val();
                console.log(c);
                var l = {};
                l.username = n, l.userMation = o, l.province = a, l.city = p, l.userWork = s, l.userMsg = r, l.email = c, $(".applyBtn button").html("提交中"), $.post(module + "/Api/msgSend", l, function (t) {
                    if (0 == t.error) {
                        var e = tipDialog(t.msg, $(".applyWrap"), 1e3);
                        e(function () {
                            $(".tipMsg").remove()
                        }), setTimeout(function () {
                            $(".applyModel").hide()
                        }, 2e3), setTimeout(function () {
                            $("#name").val(""), $("#phone").val(""), $(".career").val(""), $(".messages").val("")
                        }, 3e3)
                    }
                    $(".applyBtn button").html("提交申请")
                })
            }
        })
    })
}), $(document).keypress(function (t) {
    13 == t.which && $(".applyBtn button").click()
});