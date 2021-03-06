/**
 * Created by lenovo on 2016-01-31.
 */
$(document).ready(function () {
    initArticleParam();
});

/**
 * 初始化参数
 */
function initArticleParam() {
    var url = '';
    var deletePicWay = false;//删除图片方式
    var deleteUrl = "";
    if ($('#articleInfoId').text().trim().length <= 0) {
        url = web_path + "/student/saveArticle";
        deletePicWay = true;
        deleteUrl = web_path + "/student/deleteFile";
    } else {
        url = web_path + "/student/updateArticle";
        deletePicWay = false;
    }
    param.articleWordType = "系简介";
    param.checkArticleTitle = true;
    param.checkArticleContent = true;
    param.checkArticlePic = false;
    param.articleSaveOrUpdateUrl = url;
    param.clickOkUrl = web_path + "/user/tie/tieArticleShow";
    param.clickNoUrl = web_path + "/maintainer/tie/tieIntroduceUpdate";
    param.uploadParamFileName = "tieintroduce";
    param.myParam = {
        'articleId':$('#articleInfoId').text().trim()
    }
    param.cleanFromClient = deletePicWay;
    param.cleanUrl = deleteUrl;
    initUpload();
    initImage();
}

