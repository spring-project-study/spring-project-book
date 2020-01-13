console.log("Reply module.....")

var replyService = (function () {

    function add(reply, callback, error) {
        console.log("reply.....");

        $.ajax({
            type: 'post',
            url: '/reply/new',
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function (result, status, xhr) {
                if (callback) {
                    callback(result)
                }
            },
            error: function (xhr, status, xhr) {
                if (error) {
                    error(er);
                }
            }
        })
    }

    function getList(param, callback, error) {
        var bno = param.bno;
        var page = param.page || 1;

        $.getJSON("/reply/pages/" + bno + "/" + page + ".json", //return 으로 JSON객체를 가져오니, JSON.parse()없어도 됨
            function (data) {
                if (callback) {
                    callback(data);
                }
            }).fail(function (xhr, status, error) {
            if (error) {
                error();
            }
        });
    }

    function remove(rno, callback, error) {
        $.ajax({
            type: 'delete',
            url: '/reply/' + rno,
            success: function (deleteResult, status, xhr) {
                if (callback) {
                    callback(deleteResult);
                }
            },
            error: function (xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        })
    }

    function modify(reply, callback, error) {
        $.ajax({
            type: 'put',
            url: '/reply/' + reply.rno,
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function (result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error: function (xhr, status, er) {
                if (error) {
                    error(er);
                }
            }
        });
    }

    function get(rno, callback, error) {
        $.get("/reply/" + rno + ".json", function (result) {
            if (callback) {
                callback(result);
            }
        }).fail(function (xhr, status, err) {
            if (error) {
                error();
            }
        })
    }

    return {
        add: add,
        getList: getList,
        remove: remove,
        modify: modify,
        get: get
    };
})();