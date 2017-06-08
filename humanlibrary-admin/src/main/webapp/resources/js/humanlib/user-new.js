(function (window, $) {
    var userNew = {
        isExisted: false,
        verifyLoginId: function () {
            var _this = this
            var loginId = $('.js-loginId').val() || '';
            $.ajax({
                url: $CTX_ROOT + '/user/verification/' + loginId,
                method: 'GET',
                dataType: 'json',
                success: function (data, status, xhr) {
                    if (data.isExisted) {
                        _this.isExisted = true
                        return window.alert('존재하는 아이디가 있습니다.');
                    } else {
                        _this.isExisted = false
                    }
                },
                error: function(xhr, status, err) {
                }
            });
        }
    }
    window.userNew = userNew
})(window, $);