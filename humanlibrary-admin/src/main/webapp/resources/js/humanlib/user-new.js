(function (window, $) {
    function _makeBirth() {
        var year = $('#year').val() || '';
        var month = $('#month').val() || '';
        var day = $('#day').val() || '';
        return [year, month, day].join('-');
    }

    var userNew = {
        isExisted: false,
        init: function () {
            var _this = this
            var $frm = $('.js-form');
            // @TODO error case에 따른 CSS 변경.
            $frm.validate({
                rules: {
                    loginId: {
                      required: true,
                    },
                    name: {
                        required: true
                    },
                    email: {
                        required: true,
                        email: true,
                    },
                    password: {
                        required: true
                    },
                    repassword: {
                        required: true,
                        equalTo: '#password'
                    }
                },
                submitHandler: function (form) {
                    var roles = $('input[name=roles]:checked').length
                    if (!$(form).valid()) {
                        return false
                    }
                    if (_this.isExisted) {
                        return window.alert('아이디를 확인해 주세요.')
                    }
                    if (roles === 0) {
                        return window.alert('역할은 필수입니다.')
                    }
                    $('#birth').val(_makeBirth());
                    return true
                }
            });

        },
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
                        return window.alert('사용 가능한 아이디입니다.');
                    }
                },
                error: function(xhr, status, err) {
                }
            });
        }
    }
    window.userNew = userNew
    $(document).ready(function () {
        userNew.init();
    })
})(window, $);