/**
 * Created by lenovo on 2016-02-09.
 */
(function () {
    var db = {

        loadData: function (filter) {
            return $.ajax({
                type: "GET",
                url: web_path + "/maintainer/major/majorHeadData",
                data: filter,
                dataType: "json"
            });
        }

    };

    window.db = db;

    db.majors = majors;

}());