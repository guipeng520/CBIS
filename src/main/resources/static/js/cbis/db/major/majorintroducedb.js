/**
 * Created by lenovo on 2016-02-07.
 */
(function () {
    var db = {

        loadData: function (filter) {
            return $.ajax({
                type:"GET",
                url:"/maintainer/majorIntroduceData",
                data:filter,
                dataType:"json"
            });
        }

    };

    window.db = db;

    db.majors = majors;
}());