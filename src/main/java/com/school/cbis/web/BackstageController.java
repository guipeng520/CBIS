package com.school.cbis.web;

import com.school.cbis.data.AjaxData;
import com.school.cbis.domain.Tables;
import com.school.cbis.domain.tables.pojos.*;
import com.school.cbis.service.*;
import com.school.cbis.util.FilesUtils;
import com.school.cbis.vo.personal.TeacherVo;
import org.jooq.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by lenovo on 2016-01-10.
 */
@Controller
public class BackstageController {

    @Resource
    private UploadService upload;

    @Resource
    private ArticleInfoService articleInfoService;

    @Resource
    private ArticleSubService articleSubService;

    @Resource
    private UsersService usersService;

    @Resource
    private TieService tieService;

    @Resource
    private YardService yardService;

    @Resource
    private MajorService majorService;

    @Resource
    private TeacherService teacherService;

    /**
     * 系管理界面
     *
     * @param map
     * @return
     */
    @RequestMapping("/maintainer/tieManager")
    public String tieManager(ModelMap map) {
        Result<Record> records = usersService.findAll(usersService.getUserName());
        int tieId = 0;
        if (records.isNotEmpty()) {
            for (Record r : records) {
                tieId = r.getValue(Tables.TIE.ID);
            }
        }
        Tie tie = tieService.findById(tieId);
        List<Yard> yardList = yardService.findAll();
        Yard yard = new Yard();
        if (!yardList.isEmpty()) {
            for (int i = 0; i < yardList.size(); i++) {
                if (yardList.get(i).getId() == tie.getYardId()) {
                    yard = yardList.get(i);
                    yardList.remove(i);
                    break;
                }
            }
        }
        map.addAttribute("tie", tie);
        map.addAttribute("yardInfo", yard);
        map.addAttribute("yardList", yardList);
        return "/maintainer/tiemanager";
    }

    /**
     * 专业管理界面
     *
     * @return
     */
    @RequestMapping("/maintainer/majormanager")
    public String majorManager() {
        return "/maintainer/majorlist";
    }

    /**
     * 专业简介界面
     *
     * @return
     */
    @RequestMapping("/maintainer/majorintroduce")
    public String majorIntroduce() {
        return "/maintainer/majorintroducelist";
    }

    /**
     * 专业带头人界面
     *
     * @return
     */
    @RequestMapping("/maintainer/majorhead")
    public String majorHead() {
        return "/maintainer/majorheadlist";
    }

    /**
     * 专业培养目标
     *
     * @return
     */
    @RequestMapping("/maintainer/majortraininggoal")
    public String majorTrainingGoal() {
        return "/maintainer/majortraininggoallist";
    }

    /**
     * 专业特色
     *
     * @return
     */
    @RequestMapping("/maintainer/majortrait")
    public String majorTrait() {
        return "/maintainer/majortraitlist";
    }

    @RequestMapping("/maintainer/grademanager")
    public String gradeManager(ModelMap map) {
        //通过用户类型获取系表ID
        Result<Record> records = usersService.findAll(usersService.getUserName());
        int tieId = 0;
        if (records.isNotEmpty()) {
            for (Record r : records) {
                tieId = r.getValue(Tables.TIE.ID);
            }
        }
        List<Major> majors = majorService.findByTieId(tieId);
        map.addAttribute("majorNames", majors);
        return "/maintainer/gradelist";
    }

    @RequestMapping("/maintainer/usersmanager")
    public String usersManager() {
        return "/maintainer/studentlist";
    }

    @RequestMapping("/maintainer/studentmanager")
    public String studentManager(ModelMap map) {
        return "/maintainer/studentlist";
    }

    @RequestMapping("/maintainer/teachermanager")
    public String teacherManager(ModelMap map) {
        List<TeacherVo> teacherVos = new ArrayList<>();
        //通过用户类型获取系表ID
        Result<Record> records = usersService.findAll(usersService.getUserName());
        int tieId = 0;
        if (records.isNotEmpty()) {
            for (Record r : records) {
                tieId = r.getValue(Tables.TIE.ID);
            }
        }
        Result<Record5<Integer, String, String, Byte, String>> record5s = teacherService.findByTieId(tieId);
        if (record5s.isNotEmpty()) {
            teacherVos = record5s.into(TeacherVo.class);
        }
        map.addAttribute("teachers", teacherVos);
        return "/maintainer/teacherlist";
    }


}
