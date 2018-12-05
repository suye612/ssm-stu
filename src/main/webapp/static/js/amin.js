var Amin = {
    alert: function (info, iconIndex) {
        parent.layer.msg(info, {
            icon: iconIndex,
            time: 1500
        });
    },
    confirm: function (tip, ensure) {//询问框
        parent.layer.confirm(tip, {
            btn: ['确定', '取消']
        }, function (index) {
            ensure();
            parent.layer.close(index);
        }, function (index) {
            parent.layer.close(index);
        });
    },
    info: function (info) {
        Amin.alert(info, 0);
    },
    success: function (info) {
        Amin.alert(info, 1);
    },
    error: function (info) {
        Amin.alert(info, 2);
    }
}