package com.school.cbis.web.autonomicpractice;

import com.alibaba.fastjson.JSON;
import com.school.cbis.commons.Wordbook;
import com.school.cbis.data.*;
import com.school.cbis.domain.Tables;
import com.school.cbis.domain.tables.pojos.*;
import com.school.cbis.domain.tables.records.AuthoritiesRecord;
import com.school.cbis.domain.tables.records.AutonomousPracticeTemplateRecord;
import com.school.cbis.service.*;
import com.school.cbis.util.RandomUtils;
import com.school.cbis.vo.autonomicpractice.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jooq.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by lenovo on 2016-04-04.
 */
@Controller
public class AutonomicPracticeController {

    private final Logger log = LoggerFactory.getLogger(AutonomicPracticeController.class);

    @Resource
    private UsersService usersService;

    @Resource
    private GradeService gradeService;

    @Resource
    private AutonomousPracticeInfoService autonomousPracticeInfoService;

    @Resource
    private AutonomousPracticeTemplateService autonomousPracticeTemplateService;

    @Resource
    private HeadTypeService headTypeService;

    @Resource
    private AutonomousPracticeHeadService autonomousPracticeHeadService;

    @Resource
    private AutonomousPracticeContentService autonomousPracticeContentService;

    @Resource
    private TeacherService teacherService;

    @Resource
    private StudentService studentService;

    @Resource
    private AuthoritiesService authoritiesService;

    @Resource
    private MajorService majorService;

    @Resource
    private Wordbook wordbook;

    @Resource
    private SystemLogService systemLogService;

    @Resource
    private UploadService uploadService;

    /**
     * 自主实习管理界面
     *
     * @return
     */
    @RequestMapping("/student/autonomicpractice/autonomicPracticeManager")
    public String autonomicPracticeManager() {
        if (usersService.isCurrentUserInRole(Wordbook.CBIS_ADMIN)) {//管理员可进入
            return "redirect:/administrator/autonomicpractice/reportsettingList";
        } else {
            return "redirect:/student/autonomicpractice/autonomicPractice";
        }
    }

    /**
     * 自主实习填报设置
     *
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/reportsettingList")
    public String reportSetting(ReportSettingVo reportSettingVo, ModelMap modelMap) {
        modelMap.addAttribute("reportSettingVo", reportSettingVo);
        return "/administrator/autonomicpractice/reportsettinglist";
    }

    /**
     * 自主实习填报设置列表数据
     *
     * @param reportSettingVo
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/reportSettingData")
    @ResponseBody
    public AjaxData<ReportSettingVo> reportSettingData(ReportSettingVo reportSettingVo) {
        AjaxData<ReportSettingVo> ajaxData = new AjaxData<>();
        Record record = usersService.findAll(usersService.getUserName());
        int tieId = 0;
        if (!ObjectUtils.isEmpty(record)) {
            tieId = record.getValue(Tables.TIE.ID);
        }
        List<ReportSettingVo> list = new ArrayList<>();
        if (tieId > 0) {
            Result<Record7<Integer, String, Timestamp, String, Timestamp, Timestamp, String>> record7s = autonomousPracticeInfoService.findByTieIdAndPage(reportSettingVo, tieId);
            if (record7s.isNotEmpty()) {
                list = record7s.into(ReportSettingVo.class);
                PaginationData paginationData = new PaginationData();
                paginationData.setPageNum(reportSettingVo.getPageNum());
                paginationData.setPageSize(reportSettingVo.getPageSize());
                paginationData.setTotalDatas(autonomousPracticeInfoService.findByTieIdAndCount(reportSettingVo, tieId));
                ajaxData.success().listData(list).paginationData(paginationData);
            } else {
                ajaxData.fail().listData(list);
            }
        } else {
            ajaxData.fail().listData(list);
        }

        return ajaxData;
    }

    /**
     * 删除自主实习
     *
     * @param reportSettingVo
     * @return
     */
    @RequestMapping(value = "/administrator/autonomicpractice/deleteReportSetting", method = RequestMethod.POST)
    @ResponseBody
    public AjaxData deleteReportSetting(ReportSettingVo reportSettingVo) {
        List<AutonomousPracticeContent> autonomousPracticeContents = autonomousPracticeContentService.findByAutonomousPracticeInfoId(reportSettingVo.getId());
        if (autonomousPracticeContents.isEmpty()) {
            autonomousPracticeInfoService.deleteById(reportSettingVo.getId());
            return new AjaxData().success().msg("删除成功!");
        } else {
            return new AjaxData().fail().msg("已经有内容存在,无法删除!");
        }
    }

    /**
     * 填报设置添加
     *
     * @param modelMap
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/reportSettingAdd")
    public String reportSettingAdd(ModelMap modelMap) {
        //通过用户类型获取系表ID
        Record record = usersService.findAll(usersService.getUserName());
        int tieId = 0;
        if (!ObjectUtils.isEmpty(record)) {
            tieId = record.getValue(Tables.TIE.ID);
        }
        List<AutonomousPracticeTemplate> autonomousPracticeTemplates = autonomousPracticeTemplateService.findAllByTieId(tieId);
        if (!autonomousPracticeTemplates.isEmpty()) {
            modelMap.addAttribute("autonomousPracticeTemplate", autonomousPracticeTemplates);
        }

        List<String> list = new ArrayList<>();
        Result<Record1<String>> record1s = gradeService.findAllYearDistinct(tieId);
        if (record1s.isNotEmpty()) {
            for (Record r : record1s) {
                list.add(r.getValue("year").toString());
            }
        }
        modelMap.addAttribute("years", list);
        return "/administrator/autonomicpractice/reportsettingadd";
    }

    /**
     * 保存填报设置
     *
     * @param reportSettingAddVo
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/addReportSetting")
    public String reportSettingSave(ReportSettingAddVo reportSettingAddVo) {
        //通过用户类型获取系表ID
        Record record = usersService.findAll(usersService.getUserName());
        int tieId = 0;
        if (!ObjectUtils.isEmpty(record)) {
            tieId = record.getValue(Tables.TIE.ID);
        }
        AutonomousPracticeInfo autonomousPracticeInfo = new AutonomousPracticeInfo();
        autonomousPracticeInfo.setAutonomousPracticeTitle(reportSettingAddVo.getAutonomousPracticeTitle());
        String temp = "";
        for (String s : reportSettingAddVo.getGradeYear()) {
            temp += s + ",";
        }
        temp = temp.substring(0, temp.lastIndexOf(","));
        autonomousPracticeInfo.setGradeYear(temp);
        autonomousPracticeInfo.setAutonomousPracticeTemplateId(reportSettingAddVo.getAutonomousPracticeTemplateId());
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        ts = Timestamp.valueOf(reportSettingAddVo.getStartTime() + " 00:00:00");
        autonomousPracticeInfo.setStartTime(ts);
        ts = Timestamp.valueOf(reportSettingAddVo.getEndTime() + " 23:59:59");
        autonomousPracticeInfo.setEndTime(ts);
        autonomousPracticeInfo.setUsersId(usersService.getUserName());
        autonomousPracticeInfo.setTieId(tieId);
        autonomousPracticeInfoService.save(autonomousPracticeInfo);

        SystemLog systemLog = new SystemLog();
        systemLog.setTieId(tieId);
        systemLog.setUsername(usersService.getUserName());
        systemLog.setOperationBehavior("添加自主实习填报设置 : " + autonomousPracticeInfo.getAutonomousPracticeTitle() + "!");
        systemLogService.save(systemLog);

        return "redirect:/administrator/autonomicpractice/reportsettingList";
    }

    /**
     * 填报设置更新界面
     *
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/reportSettingUpdate")
    public String reportSettingUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        //通过用户类型获取系表ID
        Record record = usersService.findAll(usersService.getUserName());
        int tieId = 0;
        if (!ObjectUtils.isEmpty(record)) {
            tieId = record.getValue(Tables.TIE.ID);
        }
        AutonomousPracticeInfo autonomousPracticeInfo = autonomousPracticeInfoService.findById(id);
        List<AutonomousPracticeTemplate> autonomousPracticeTemplates = autonomousPracticeTemplateService.findAllByTieId(tieId);
        SelectData selectData = new SelectData();
        for (int i = 0; i < autonomousPracticeTemplates.size(); i++) {
            if (autonomousPracticeTemplates.get(i).getId() == autonomousPracticeInfo.getAutonomousPracticeTemplateId()) {
                selectData.setText(autonomousPracticeTemplates.get(i).getAutonomousPracticeTemplateTitle());
                selectData.setValue(autonomousPracticeTemplates.get(i).getId() + "");
                selectData.setSelected(true);
                autonomousPracticeTemplates.remove(i);
                break;
            }
        }
        modelMap.addAttribute("autonomousPracticeTemplateSelected", selectData);
        modelMap.addAttribute("autonomousPracticeTemplate", autonomousPracticeTemplates);

        if (!ObjectUtils.isEmpty(autonomousPracticeInfo)) {
            List<CheckboxData> list = new ArrayList<>();
            String[] isCheckedYears = autonomousPracticeInfo.getGradeYear().split(",");
            Result<Record1<String>> record1s = gradeService.findAllYearDistinct(tieId);
            if (record1s.isNotEmpty()) {
                for (Record r : record1s) {
                    CheckboxData checkboxData = new CheckboxData();
                    checkboxData.setValue(r.getValue("year").toString());
                    checkboxData.setChecked(false);
                    for (String s : isCheckedYears) {
                        if (r.getValue("year").toString().equals(s)) {
                            checkboxData.setChecked(true);
                            break;
                        }
                    }
                    list.add(checkboxData);
                }
            }
            modelMap.addAttribute("years", list);
        }
        modelMap.addAttribute("autonomousPracticeInfo", autonomousPracticeInfo);
        return "/administrator/autonomicpractice/reportsettingupdate";
    }

    /**
     * 更新填报设置信息
     *
     * @param reportSettingAddVo
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/updateReportSetting")
    public String updateReportSetting(ReportSettingAddVo reportSettingAddVo) {
        //通过用户类型获取系表ID
        Record record = usersService.findAll(usersService.getUserName());
        int tieId = 0;
        if (!ObjectUtils.isEmpty(record)) {
            tieId = record.getValue(Tables.TIE.ID);
        }
        AutonomousPracticeInfo autonomousPracticeInfo = autonomousPracticeInfoService.findById(reportSettingAddVo.getId());
        autonomousPracticeInfo.setAutonomousPracticeTitle(reportSettingAddVo.getAutonomousPracticeTitle());
        String temp = "";
        for (String s : reportSettingAddVo.getGradeYear()) {
            temp += s + ",";
        }
        temp = temp.substring(0, temp.lastIndexOf(","));
        autonomousPracticeInfo.setGradeYear(temp);
        autonomousPracticeInfo.setAutonomousPracticeTemplateId(reportSettingAddVo.getAutonomousPracticeTemplateId());
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        ts = Timestamp.valueOf(reportSettingAddVo.getStartTime() + " 00:00:00");
        autonomousPracticeInfo.setStartTime(ts);
        ts = Timestamp.valueOf(reportSettingAddVo.getEndTime() + " 23:59:59");
        autonomousPracticeInfo.setEndTime(ts);
        autonomousPracticeInfo.setUsersId(usersService.getUserName());
        autonomousPracticeInfo.setTieId(tieId);
        autonomousPracticeInfoService.update(autonomousPracticeInfo);
        return "redirect:/administrator/autonomicpractice/reportsettingList";
    }

    /**
     * 模板编辑列表
     *
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/templateList")
    public String templateList(TemplateVo templateVo, ModelMap modelMap) {
        modelMap.addAttribute("templateVo", templateVo);
        return "/administrator/autonomicpractice/templatelist";
    }

    /**
     * 模板编辑列表数据
     *
     * @param templateVo
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/templateData")
    @ResponseBody
    public AjaxData<TemplateVo> templateData(TemplateVo templateVo) {
        AjaxData<TemplateVo> ajaxData = new AjaxData<>();
        Record record = usersService.findAll(usersService.getUserName());
        int tieId = 0;
        if (!ObjectUtils.isEmpty(record)) {
            tieId = record.getValue(Tables.TIE.ID);
        }
        List<TemplateVo> list = new ArrayList<>();
        if (tieId > 0) {
            Result<Record4<Integer, String, Timestamp, String>> record4s = autonomousPracticeTemplateService.findAllAndPage(templateVo, tieId);
            if (record4s.isNotEmpty()) {
                list = record4s.into(TemplateVo.class);
                PaginationData paginationData = new PaginationData();
                paginationData.setPageNum(templateVo.getPageNum());
                paginationData.setPageSize(templateVo.getPageSize());
                paginationData.setTotalDatas(autonomousPracticeTemplateService.findAllAndCount(templateVo, tieId));
                ajaxData.success().listData(list).paginationData(paginationData);
            } else {
                ajaxData.fail().listData(list);
            }
        } else {
            ajaxData.fail().listData(list);
        }

        return ajaxData;
    }

    /**
     * 删除模板
     *
     * @param templateVo
     * @return
     */
    @RequestMapping(value = "/administrator/autonomicpractice/deleteTemplate", method = RequestMethod.POST)
    @ResponseBody
    public AjaxData deleteTemplate(TemplateVo templateVo) {
        List<AutonomousPracticeHead> autonomousPracticeHeads = autonomousPracticeHeadService.findByAutonomousPracticeTemplateId(templateVo.getId());
        autonomousPracticeHeads.forEach(m -> {
            autonomousPracticeContentService.deleteByAutonomousPracticeHeadId(m.getId());
        });
        autonomousPracticeHeadService.deleteByAutonomousPracticeTemplateId(templateVo.getId());
        autonomousPracticeInfoService.deleteByAutonomousPracticeTemplateId(templateVo.getId());
        autonomousPracticeTemplateService.deleteById(templateVo.getId());
        return new AjaxData().success().msg("删除成功!");
    }

    /**
     * 模板添加界面
     *
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/templateAdd")
    public String templateAdd() {
        return "/administrator/autonomicpractice/templateadd";
    }

    /**
     * 模板更新界面
     *
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/templateUpdate")
    public String templateUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        AutonomousPracticeTemplate autonomousPracticeTemplate = autonomousPracticeTemplateService.findById(id);
        modelMap.addAttribute("autonomousPracticeTemplate", autonomousPracticeTemplate);
        return "/administrator/autonomicpractice/templateupdate";
    }

    /**
     * 初始化模板数据
     *
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/initTemplateData")
    @ResponseBody
    public AjaxData initTemplateData() {
        Map<String, Object> map = new HashMap<>();
        map.put("headType", headTypeService.findAll());
        List<SelectData> selectDatas = new ArrayList<>();
        selectDatas.add(new SelectData(1, "student", "学生表", false));
        map.put("databaseTables", selectDatas);
        List<SelectData> tableFields = new ArrayList<>();
        tableFields.add(new SelectData(1, "student_number", "学生号", false));
        tableFields.add(new SelectData(1, "student_name", "学生姓名", false));
        tableFields.add(new SelectData(1, "grade_name", "学生班级", false));
        tableFields.add(new SelectData(1, "student_phone", "学生电话", false));
        tableFields.add(new SelectData(1, "student_email", "学生邮箱", false));
        tableFields.add(new SelectData(1, "student_birthday", "学生生日", false));
        tableFields.add(new SelectData(1, "student_sex", "学生性别", false));
        tableFields.add(new SelectData(1, "student_identity_card", "学生身份证号", false));
        tableFields.add(new SelectData(1, "student_address", "学生地址", false));
        map.put("tableFileds", tableFields);
        map.put("roleList", wordbook.getRoleString());
        return new AjaxData().success().mapData(map);
    }

    /**
     * 检验添加模板名是否重复
     *
     * @param templateName
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/validateAddAutonomicPracticeTemplateTitle")
    @ResponseBody
    public AjaxData validateAddAutonomicPracticeTemplateTitle(@RequestParam("templateName") String templateName) {
        if (StringUtils.hasLength(templateName)) {
            Record record = usersService.findAll(usersService.getUserName());
            int tieId = 0;
            if (!ObjectUtils.isEmpty(record)) {
                tieId = record.getValue(Tables.TIE.ID);
            }
            AutonomousPracticeTemplateRecord autonomousPracticeTemplateRecord = autonomousPracticeTemplateService.findByAutonomousPracticeTemplateTitleAndTieIdEq(templateName, tieId);
            if (ObjectUtils.isEmpty(autonomousPracticeTemplateRecord)) {
                return new AjaxData().success().msg("可以使用!");
            } else {
                return new AjaxData().fail().msg("模板已存在!");
            }

        } else {
            return new AjaxData().fail().msg("请填写模板名!");
        }
    }

    /**
     * 检验更新模板名是否重复
     *
     * @param templateId
     * @param templateName
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/validateUpdateAutonomicPracticeTemplateTitle")
    @ResponseBody
    public AjaxData validateUpdateAutonomicPracticeTemplateTitle(@RequestParam("id") int templateId, @RequestParam("templateName") String templateName) {
        if (StringUtils.hasLength(templateName)) {
            Record record = usersService.findAll(usersService.getUserName());
            int tieId = 0;
            if (!ObjectUtils.isEmpty(record)) {
                tieId = record.getValue(Tables.TIE.ID);
            }
            AutonomousPracticeTemplateRecord autonomousPracticeTemplateRecord = autonomousPracticeTemplateService.findByAutonomousPracticeTemplateTitleAndTieIdAndNeId(templateId, templateName, tieId);
            if (ObjectUtils.isEmpty(autonomousPracticeTemplateRecord)) {
                return new AjaxData().success().msg("可以使用!");
            } else {
                return new AjaxData().fail().msg("模板已存在!");
            }

        } else {
            return new AjaxData().fail().msg("请填写模板名!");
        }
    }

    /**
     * 添加模板
     *
     * @param templateName
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/addAutonomicPracticeTemplate")
    @ResponseBody
    public AjaxData addAutonomicPracticeTemplate(@RequestParam("templateName") String templateName) {
        if (StringUtils.hasLength(templateName)) {
            Record record = usersService.findAll(usersService.getUserName());
            int tieId = 0;
            if (!ObjectUtils.isEmpty(record)) {
                tieId = record.getValue(Tables.TIE.ID);
            }
            AutonomousPracticeTemplate autonomousPracticeTemplate = new AutonomousPracticeTemplate();
            autonomousPracticeTemplate.setAutonomousPracticeTemplateTitle(templateName);
            autonomousPracticeTemplate.setUsersId(usersService.getUserName());
            autonomousPracticeTemplate.setTieId(tieId);
            int id = autonomousPracticeTemplateService.save(autonomousPracticeTemplate);


            SystemLog systemLog = new SystemLog();
            systemLog.setTieId(tieId);
            systemLog.setUsername(usersService.getUserName());
            systemLog.setOperationBehavior("添加自主实习模板" + templateName + "成功!");
            systemLogService.save(systemLog);

            return new AjaxData().success().obj(id);
        } else {
            return new AjaxData().fail().msg("请填写模板名!");
        }
    }

    /**
     * 更新模板
     *
     * @param templateId
     * @param templateName
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/updateAutonomicPracticeTemplate")
    @ResponseBody
    public AjaxData<AutonomousPracticeHeadAddVo> updateAutonomicPracticeTemplate(@RequestParam("id") int templateId, @RequestParam("templateName") String templateName) {
        if (StringUtils.hasLength(templateName)) {
            AutonomousPracticeTemplate autonomousPracticeTemplate = autonomousPracticeTemplateService.findById(templateId);

            SystemLog systemLog = new SystemLog();
            systemLog.setTieId(autonomousPracticeTemplate.getTieId());
            systemLog.setUsername(usersService.getUserName());
            systemLog.setOperationBehavior("更新自主实习模板标题" + autonomousPracticeTemplate.getAutonomousPracticeTemplateTitle() + "为" + templateName + "!");
            systemLogService.save(systemLog);

            autonomousPracticeTemplate.setAutonomousPracticeTemplateTitle(templateName);
            autonomousPracticeTemplateService.update(autonomousPracticeTemplate);
            Result<Record14<Integer, String, String, String, String, String, String, String, Byte, String, Byte, Integer, Byte, Integer>> record14s = autonomousPracticeHeadService.findByAutonomousPracticeTemplateIdWithHeadTypeId(templateId);
            List<AutonomousPracticeHeadAddVo> autonomousPracticeHeadAddVos = new ArrayList<>();

            if (record14s.isNotEmpty()) {
                autonomousPracticeHeadAddVos = record14s.into(AutonomousPracticeHeadAddVo.class);
            }


            return new AjaxData<AutonomousPracticeHeadAddVo>().success().obj(templateId).listData(autonomousPracticeHeadAddVos);
        } else {
            return new AjaxData<AutonomousPracticeHeadAddVo>().fail().msg("请填写模板名!");
        }
    }

    /**
     * 添加自主实习标题
     *
     * @param autonomousPracticeHeadListVo
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/addAutonomicPracticeHead")
    @ResponseBody
    public AjaxData addAutonomicPracticeHead(AutonomousPracticeHeadListVo autonomousPracticeHeadListVo) {
        log.debug("autonomousPracticeHeadListVo : {}", autonomousPracticeHeadListVo);
        if (autonomousPracticeHeadListVo.getId() > 0) {
            AutonomousPracticeHead autonomousPracticeHead = new AutonomousPracticeHead();
            autonomousPracticeHead.setTitle(autonomousPracticeHeadListVo.getTitle());
            autonomousPracticeHead.setTitleVariable(RandomUtils.generateTitleVariable());
            autonomousPracticeHead.setHeadTypeId(autonomousPracticeHeadListVo.getHeadTypeSelect());
            if (autonomousPracticeHeadListVo.getIsDatabase() == 1) {
                autonomousPracticeHead.setDatabaseTable("student");
            } else {
                autonomousPracticeHead.setDatabaseTable("");
            }
            autonomousPracticeHead.setDatabaseTableField(autonomousPracticeHeadListVo.getDatabaseFieldSelect());
            autonomousPracticeHead.setAuthority(autonomousPracticeHeadListVo.getAuthority());
            autonomousPracticeHead.setIsShowHighlyActive(autonomousPracticeHeadListVo.getIsShowHighlyActive());
            autonomousPracticeHead.setIsRequired(autonomousPracticeHeadListVo.getIsRequired());
            autonomousPracticeHead.setAutonomousPracticeTemplateId(autonomousPracticeHeadListVo.getId());
            autonomousPracticeHead.setContent(autonomousPracticeHeadListVo.getSelectContentInput());
            autonomousPracticeHead.setIsDatabase(autonomousPracticeHeadListVo.getIsDatabase());
            autonomousPracticeHead.setSort(autonomousPracticeHeadListVo.getSort());
            int id = autonomousPracticeHeadService.save(autonomousPracticeHead);
            autonomousPracticeHead.setId(id);
            return new AjaxData().success().obj(autonomousPracticeHead);
        } else {
            return new AjaxData().fail().msg("参数异常!");
        }
    }

    /**
     * 更新自主实习标题
     *
     * @param autonomousPracticeHeadUpdateVo
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/updateAutonomicPracticeHead")
    @ResponseBody
    public AjaxData updateAutonomicPracticeHead(AutonomousPracticeHeadUpdateVo autonomousPracticeHeadUpdateVo) {
        log.debug("autonomousPracticeHeadListVo : {}", autonomousPracticeHeadUpdateVo);
        if (autonomousPracticeHeadUpdateVo.getId() > 0) {
            AutonomousPracticeHead autonomousPracticeHead = autonomousPracticeHeadService.findById(autonomousPracticeHeadUpdateVo.getId());
            autonomousPracticeHead.setTitle(autonomousPracticeHeadUpdateVo.getTitle());
            autonomousPracticeHead.setHeadTypeId(autonomousPracticeHeadUpdateVo.getHeadTypeSelect());
            if (autonomousPracticeHeadUpdateVo.getIsDatabase() == 1) {
                autonomousPracticeHead.setDatabaseTable("student");
            } else {
                autonomousPracticeHead.setDatabaseTable("");
            }
            autonomousPracticeHead.setDatabaseTableField(autonomousPracticeHeadUpdateVo.getDatabaseFieldSelect());
            autonomousPracticeHead.setAuthority(autonomousPracticeHeadUpdateVo.getAuthority());
            autonomousPracticeHead.setIsShowHighlyActive(autonomousPracticeHeadUpdateVo.getIsShowHighlyActive());
            autonomousPracticeHead.setContent(autonomousPracticeHeadUpdateVo.getSelectContentInput());
            autonomousPracticeHead.setIsDatabase(autonomousPracticeHeadUpdateVo.getIsDatabase());
            autonomousPracticeHead.setIsRequired(autonomousPracticeHeadUpdateVo.getIsRequired());
            autonomousPracticeHeadService.update(autonomousPracticeHead);
            //更新内容为空
            List<AutonomousPracticeContent> autonomousPracticeContents = autonomousPracticeContentService.findByAutonomousPracticeHeadId(autonomousPracticeHead.getId());
            for(AutonomousPracticeContent a:autonomousPracticeContents){
                a.setContent("");
                autonomousPracticeContentService.update(a);
            }

            return new AjaxData().success().obj(autonomousPracticeHead);
        } else {
            return new AjaxData().fail().msg("参数异常!");
        }
    }

    /**
     * 删除自主实习标题
     *
     * @param headId
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/deleteAutonomicPracticeHead")
    @ResponseBody
    public AjaxData deleteAutonomicPracticeHead(@RequestParam("id") int headId) {
        if (headId > 0) {
            autonomousPracticeContentService.deleteByAutonomousPracticeHeadId(headId);
            autonomousPracticeHeadService.deleteById(headId);
            return new AjaxData().success().msg("删除标题成功!").obj(headId);
        } else {
            return new AjaxData().fail().msg("参数异常!");
        }
    }

    /**
     * 更新标题是否显示在高效工作区
     *
     * @param id
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/updateAutonomicPracticeHeadHighlyShow")
    @ResponseBody
    public AjaxData updateAutonomicPracticeHeadHighlyShow(@RequestParam("id") int id) {
        AutonomousPracticeHead autonomousPracticeHead = autonomousPracticeHeadService.findById(id);
        Byte bytes = 0;
        if (autonomousPracticeHead.getIsShowHighlyActive() == 0) {
            bytes = 1;
        } else {
            bytes = 0;
        }
        autonomousPracticeHead.setIsShowHighlyActive(bytes);
        autonomousPracticeHeadService.update(autonomousPracticeHead);
        return new AjaxData().success();
    }

    /**
     * 更新高效工作区标题显示顺序
     *
     * @param sort
     * @return
     */
    @RequestMapping("/administrator/autonomicpractice/updateAutonomicPracticeHeadHighlySort")
    @ResponseBody
    public AjaxData updateAutonomicPracticeHeadHighlySort(@RequestParam("sort") String sort) {
        if (StringUtils.hasLength(sort)) {
            String[] temp = sort.split(",");
            for (int i = 0; i < temp.length; i++) {
                AutonomousPracticeHead autonomousPracticeHead = autonomousPracticeHeadService.findById(Integer.parseInt(temp[i]));
                autonomousPracticeHead.setSort(i);
                autonomousPracticeHeadService.update(autonomousPracticeHead);
            }
        }
        return new AjaxData().success();
    }

    /**
     * 自主实习列表页
     *
     * @return
     */
    @RequestMapping("/student/autonomicpractice/autonomicPractice")
    public String autonomicPractice() {
        return "/student/autonomicpractice/autonomicpracticelist";
    }

    /**
     * 自主实习列表页数据
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/student/autonomicpractice/autonomicPracticeData")
    @ResponseBody
    public AjaxData<AutonomicPracticeListVo> autonomicPracticeData(int pageNum, int pageSize) {
        //获取当前用户信息
        Record record = usersService.findAll(usersService.getUserName());
        int tieId = 0;
        boolean isStudent = false;//本人是否为学生
        String studentYear = null;//本人年级
        if (!ObjectUtils.isEmpty(record)) {
            if (wordbook.getUserTypeMap().get(Wordbook.USER_TYPE_STUDENT) == record.getValue(Tables.USERS.USER_TYPE_ID)) {
                isStudent = true;
                studentYear = record.getValue(Tables.GRADE.YEAR);
            }
            tieId = record.getValue(Tables.TIE.ID);
        }

        //处理数据
        Result<Record11<Integer, String, Timestamp, String, String, Timestamp, Timestamp, String, Integer, Integer, String>> record11s
                = autonomousPracticeInfoService.findByTieIdAndPage(tieId, pageNum, pageSize);
        if (record11s.isNotEmpty()) {
            List<AutonomicPracticeListVo> autonomicPracticeListVos = record11s.into(AutonomicPracticeListVo.class);
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            for (AutonomicPracticeListVo autonomicPracticeListVo : autonomicPracticeListVos) {
                if (isStudent) {//是学生
                    if (ts.after(autonomicPracticeListVo.getStartTime()) && ts.before(autonomicPracticeListVo.getEndTime())) {//是否不在时间范围
                        String[] gradeYears = autonomicPracticeListVo.getGradeYear().split(",");
                        boolean isRight = false;
                        for (String s : gradeYears) {
                            if (s.equals(studentYear)) {//是否在年级中
                                isRight = true;
                                break;
                            }
                        }
                        autonomicPracticeListVo.setOk(isRight);
                    } else {
                        autonomicPracticeListVo.setOk(false);
                    }
                } else {//不是学生用户
                    if (ts.after(autonomicPracticeListVo.getStartTime()) && ts.before(autonomicPracticeListVo.getEndTime())) {//是否不在时间范围
                        autonomicPracticeListVo.setOk(true);
                    } else {
                        autonomicPracticeListVo.setOk(false);
                    }
                }

                autonomicPracticeListVo.setStartTimeString(autonomicPracticeListVo.getStartTime().toString());
                autonomicPracticeListVo.setEndTimeString(autonomicPracticeListVo.getEndTime().toString());
            }
            //分页参数
            PaginationData paginationData = new PaginationData();
            paginationData.setPageSize(pageSize);
            paginationData.setPageNum(pageNum);
            paginationData.setTotalDatas(autonomousPracticeInfoService.findByTieIdAndPageCount(tieId));

            return new AjaxData<AutonomicPracticeListVo>().success().listData(autonomicPracticeListVos).paginationData(paginationData);
        } else {
            return new AjaxData<AutonomicPracticeListVo>().fail().msg("无数据!");
        }
    }

    /**
     * 进入填报前
     *
     * @param modelMap
     * @param id       autonomousPracticeInfo id  是根据tieId查询出来的
     * @return
     */
    @RequestMapping("/student/autonomicpractice/autonomicPracticeAdd")
    public String autonomicPracticeAdd(ModelMap modelMap, @RequestParam("id") int id) {

        AutonomousPracticeInfo autonomousPracticeInfo = autonomousPracticeInfoService.findById(id);

        //获取当前用户信息
        Record record = usersService.findAll(usersService.getUserName());
        boolean isStudent = false;//本人是否为学生
        String studentYear = null;//本人年级
        int studentId = 0;
        if (!ObjectUtils.isEmpty(record)) {
            if (wordbook.getUserTypeMap().get(Wordbook.USER_TYPE_STUDENT) == record.getValue(Tables.USERS.USER_TYPE_ID)) {
                isStudent = true;
                studentYear = record.getValue(Tables.GRADE.YEAR);
                studentId = record.getValue(Tables.STUDENT.ID);
                //当前填报学生的个人信息，用于数据库字段
                AutonomicPracticeStudentInfoVo autonomicPracticeStudentInfoVo = new AutonomicPracticeStudentInfoVo();
                autonomicPracticeStudentInfoVo.setId(record.getValue(Tables.STUDENT.ID));
                autonomicPracticeStudentInfoVo.setStudentNumber(record.getValue(Tables.STUDENT.STUDENT_NUMBER));
                autonomicPracticeStudentInfoVo.setStudentName(record.getValue(Tables.USERS.REAL_NAME));
                autonomicPracticeStudentInfoVo.setStudentPhone(record.getValue(Tables.USERS.MOBILE));
                autonomicPracticeStudentInfoVo.setStudentEmail(record.getValue(Tables.USERS.EMAIL));
                autonomicPracticeStudentInfoVo.setStudentBirthday(record.getValue(Tables.USERS.BIRTHDAY));
                autonomicPracticeStudentInfoVo.setStudentSex(record.getValue(Tables.USERS.SEX));
                autonomicPracticeStudentInfoVo.setStudentIdentityCard(record.getValue(Tables.USERS.IDENTITY_CARD));
                autonomicPracticeStudentInfoVo.setStudentAddress(record.getValue(Tables.USERS.FAMILY_RESIDENCE));
                autonomicPracticeStudentInfoVo.setGradeName(record.getValue(Tables.GRADE.GRADE_NAME));
                modelMap.addAttribute("studentInfo", autonomicPracticeStudentInfoVo);
            }
        }

        if (isStudent) {//是学生
            Timestamp ts = new Timestamp(System.currentTimeMillis());
            if (ts.after(autonomousPracticeInfo.getStartTime()) && ts.before(autonomousPracticeInfo.getEndTime())) {//是否不在时间范围
                String[] gradeYears = autonomousPracticeInfo.getGradeYear().split(",");
                boolean isRight = false;
                for (String s : gradeYears) {
                    if (s.equals(studentYear)) {//是否在年级中
                        isRight = true;
                        break;
                    }
                }
                if (isRight) {

                    //当前填报学生是否已经填报过，若已填报过，则这次视为更新操作
                    Result<Record> record5s = autonomousPracticeContentService.findByAutonomousPracticeInfoIdAndStudentId(autonomousPracticeInfo.getId(), studentId);
                    if (record5s.isNotEmpty()) {
                        List<AutonomousPracticeContent> autonomousPracticeContents = record5s.into(AutonomousPracticeContent.class);
                        modelMap.addAttribute("isUpdate", true);
                        modelMap.addAttribute("autonomousPracticeContents", autonomousPracticeContents);
                    } else {
                        modelMap.addAttribute("isUpdate", false);
                    }
                    //标题信息以及当前用户权限信息
                    Result<Record14<Integer, String, String, String, String, String, String, String, Byte, String, Byte, Integer, Byte, Integer>> record14s = autonomousPracticeHeadService.findByAutonomousPracticeTemplateIdWithHeadTypeId(autonomousPracticeInfo.getAutonomousPracticeTemplateId());
                    List<AutonomousPracticeHeadAddVo> autonomousPracticeHeadAddVos = new ArrayList<>();

                    if (record14s.isNotEmpty()) {
                        autonomousPracticeHeadAddVos = record14s.into(AutonomousPracticeHeadAddVo.class);
                    }

                    List<AuthoritiesRecord> authoritiesRecords = authoritiesService.findByUsername(usersService.getUserName());
                    List<Authorities> authoritiesList = new ArrayList<>();
                    for (AuthoritiesRecord r : authoritiesRecords) {//视图层无法解析 AuthoritiesRecord对象 ，只能转化一下了
                        Authorities authorities = new Authorities(r.getUsername(), r.getAuthority());
                        authoritiesList.add(authorities);
                    }

                    modelMap.addAttribute("heads", autonomousPracticeHeadAddVos);
                    modelMap.addAttribute("currentAuthorities", authoritiesList);
                    modelMap.addAttribute("autonomousPracticeInfoId", autonomousPracticeInfo.getId());

                    return "/student/autonomicpractice/autonomicpracticestudentadd";//学生自主实习界面
                } else {
                    return "redirect:/student/autonomicpractice/autonomicPractice";//不在该年级中
                }

            } else {
                return "redirect:/student/autonomicpractice/autonomicPractice";//不在时间范围
            }
        } else {//不是学生
            return "redirect:/teacher/autonomicpractice/autonomicPracticeTeacherList?autonomousPracticeInfoId=" + autonomousPracticeInfo.getId();//教师以上权限自主实习界面
        }
    }

    /**
     * 学生添加自主实习信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/student/autonomicpractice/addAutonomicPractice")
    @ResponseBody
    public AjaxData addAutonomicPractice(HttpServletRequest request) {
        if (StringUtils.hasLength(request.getParameter("autonomousPracticeInfoId"))) {
            int autonomousPracticeInfoId = Integer.parseInt(request.getParameter("autonomousPracticeInfoId"));
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            saveOrUpdateAutonomousPracticeContent(autonomousPracticeInfoId, studentId, request);
        } else {
            return new AjaxData().fail().msg("参数异常!");
        }
        return new AjaxData().success().msg("保存成功!");
    }

    /**
     * 教师自主实习列表
     *
     * @param autonomicPracticeTeacherListVo 参数{autonomousPracticeInfoId,pageNum,pageSize,totalData,autonomousPracticeHeadId,content}
     * @return
     */
    @RequestMapping("/teacher/autonomicpractice/autonomicPracticeTeacherList")
    public String autonomicPracticeTeacherList(AutonomicPracticeTeacherListVo autonomicPracticeTeacherListVo, ModelMap modelMap) {
        AutonomousPracticeInfo autonomousPracticeInfo = autonomousPracticeInfoService.findById(autonomicPracticeTeacherListVo.getAutonomousPracticeInfoId());
        autonomicPracticeTeacherListVo.setAutonomousPracticeTitle(autonomousPracticeInfo.getAutonomousPracticeTitle());
        modelMap.put("autonomicPracticeTeacherListVo", autonomicPracticeTeacherListVo);
        return "/teacher/autonomicpractice/autonomicpracticeteacherlist";
    }

    /**
     * 教师自主实习列表数据
     *
     * @param autonomicPracticeTeacherListVo
     * @return
     */
    @RequestMapping("/teacher/autonomicpractice/autonomicPracticeTeacherData")
    @ResponseBody
    public AjaxData autonomicPracticeTeacherData(AutonomicPracticeTeacherListVo autonomicPracticeTeacherListVo) {
        //查询该自主实习下学生填报总数
        AutonomousPracticeInfo autonomousPracticeInfo = autonomousPracticeInfoService.findById(autonomicPracticeTeacherListVo.getAutonomousPracticeInfoId());
        Result<Record1<Integer>> record1s = autonomousPracticeContentService.findByAutonomousPracticeInfoIdDistinctStudentIdAndPage(autonomicPracticeTeacherListVo);

        //查询对应该自主实习下的模板 要显示在高效工作区的标题
        List<AutonomicPracticeTeacherVo> autonomicPracticeTeacherVos = new ArrayList<>();
        List<Integer> studentIds = new ArrayList<>();

        //当前用户所有权限
        List<AuthoritiesRecord> authoritiesRecords = authoritiesService.findByUsername(usersService.getUserName());

        //isShowHighlyActive
        Byte b = 1;
        int count = 0;
        List<AutonomicPracticeHeadTypeVo> selectDatas = new ArrayList<>();//标题搜索用

        //查询出此次自主实习的所有高效工作区标题
        Result<Record> autonomousPracticeHeadRecords = autonomousPracticeHeadService.findByAutonomousPracticeTemplateIdAndIsShowHighlyActive(autonomousPracticeInfo.getAutonomousPracticeTemplateId(), b);

        for (Record r : record1s) {//分页要查询的学生

            //该学生对应的所有标题
            Result<Record> records = autonomousPracticeContentService.findByAutonomousPracticeInfoIdAndStudentIdAndIsShowHighlyActive(autonomousPracticeInfo.getId(), r.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.STUDENT_ID), b);

            for (Record ah : autonomousPracticeHeadRecords) {
                if (useTitle(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.AUTHORITY), authoritiesRecords)) {//当前用户有权限使用
                    boolean hasContent = false;
                    for (Record h : records) {//该标题已经被当前学生填写过
                        if (ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.ID) == h.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.AUTONOMOUS_PRACTICE_HEAD_ID)) {
                            AutonomicPracticeTeacherVo autonomicPracticeTeacherVo = new AutonomicPracticeTeacherVo();
                            autonomicPracticeTeacherVo.setAutonomousPracticeInfoId(autonomousPracticeInfo.getId());
                            autonomicPracticeTeacherVo.setStudentId(r.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.STUDENT_ID));
                            autonomicPracticeTeacherVo.setTitle(h.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.TITLE));
                            autonomicPracticeTeacherVo.setTitleVariable(h.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.TITLE_VARIABLE));
                            autonomicPracticeTeacherVo.setTypeName(h.getValue(Tables.HEAD_TYPE.TYPE_NAME));
                            autonomicPracticeTeacherVo.setTypeValue(h.getValue(Tables.HEAD_TYPE.TYPE_VALUE));
                            autonomicPracticeTeacherVo.setDatabaseTable(h.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.DATABASE_TABLE));
                            autonomicPracticeTeacherVo.setDatabaseTableField(h.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.DATABASE_TABLE_FIELD));
                            autonomicPracticeTeacherVo.setAuthority(h.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.AUTHORITY));
                            autonomicPracticeTeacherVo.setHeadContent(h.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.CONTENT));
                            autonomicPracticeTeacherVo.setContent(h.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.CONTENT));
                            autonomicPracticeTeacherVo.setIsDatabase(h.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.IS_DATABASE));
                            autonomicPracticeTeacherVo.setIsRequired(h.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.IS_REQUIRED));
                            autonomicPracticeTeacherVos.add(autonomicPracticeTeacherVo);
                            hasContent = true;
                            break;
                        }
                    }

                    if (!hasContent) {//未被填写过
                        AutonomicPracticeTeacherVo autonomicPracticeTeacherVo = new AutonomicPracticeTeacherVo();
                        autonomicPracticeTeacherVo.setAutonomousPracticeInfoId(autonomousPracticeInfo.getId());
                        autonomicPracticeTeacherVo.setStudentId(r.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.STUDENT_ID));
                        autonomicPracticeTeacherVo.setTitle(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.TITLE));
                        autonomicPracticeTeacherVo.setTitleVariable(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.TITLE_VARIABLE));
                        autonomicPracticeTeacherVo.setTypeName(ah.getValue(Tables.HEAD_TYPE.TYPE_NAME));
                        autonomicPracticeTeacherVo.setTypeValue(ah.getValue(Tables.HEAD_TYPE.TYPE_VALUE));
                        autonomicPracticeTeacherVo.setDatabaseTable(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.DATABASE_TABLE));
                        autonomicPracticeTeacherVo.setDatabaseTableField(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.DATABASE_TABLE_FIELD));
                        autonomicPracticeTeacherVo.setAuthority(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.AUTHORITY));
                        autonomicPracticeTeacherVo.setHeadContent(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.CONTENT));
                        autonomicPracticeTeacherVo.setIsDatabase(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.IS_DATABASE));
                        autonomicPracticeTeacherVo.setIsRequired(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.IS_REQUIRED));
                        autonomicPracticeTeacherVos.add(autonomicPracticeTeacherVo);
                    }
                    if (count == 0) {
                        AutonomicPracticeHeadTypeVo selectData = new AutonomicPracticeHeadTypeVo();
                        selectData.setValue(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.ID) + "");
                        selectData.setText(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.TITLE));
                        selectData.setTypeValue(ah.getValue(Tables.HEAD_TYPE.TYPE_VALUE));
                        selectData.setTypeName(ah.getValue(Tables.HEAD_TYPE.TYPE_NAME));
                        selectData.setContent(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.CONTENT));
                        selectData.setDatabaseTableField(ah.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.DATABASE_TABLE_FIELD));
                        selectDatas.add(selectData);
                    }

                }
            }
            count++;
            studentIds.add(r.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.STUDENT_ID));
        }
        Map<String, Object> map = new HashMap<>();
        map.put("autonomicPracticeTeacherVos", autonomicPracticeTeacherVos);
        map.put("studentIds", studentIds);

        List<Authorities> authoritiesList = new ArrayList<>();
        for (AuthoritiesRecord r : authoritiesRecords) {//视图层无法解析 AuthoritiesRecord对象 ，只能转化一下了
            Authorities authorities = new Authorities(r.getUsername(), r.getAuthority());
            authoritiesList.add(authorities);
        }
        autonomicPracticeTeacherListVo.setTotalData(autonomousPracticeContentService.findByAutonomousPracticeInfoIdDistinctStudentIdAndPageCount(autonomicPracticeTeacherListVo));
        map.put("currentAuthorities", authoritiesList);
        map.put("searchHeads", selectDatas);
        map.put("autonomicPracticeTeacherListVo", autonomicPracticeTeacherListVo);
        return new AjaxData().success().mapData(map);
    }

    /**
     * 导出自主实习列表数据
     *
     * @param fileName 文件名
     * @param ext      文件后缀 默认 xlsx
     */
    @RequestMapping("/teacher/autonomicpractice/exportAutonomicPracticeData")
    public void exportAutonomicPracticeData(int autonomousPracticeHeadId, String content, int autonomousPracticeInfoId, @RequestParam(value = "fileName", required = false) String fileName,
                                            @RequestParam(value = "ext", defaultValue = Wordbook.EXCEL_XLSX, required = false) String ext, HttpServletRequest request, HttpServletResponse response) {
        try {
            AutonomicPracticeTeacherListVo autonomicPracticeTeacherListVo = new AutonomicPracticeTeacherListVo();
            autonomicPracticeTeacherListVo.setAutonomousPracticeHeadId(autonomousPracticeHeadId);
            autonomicPracticeTeacherListVo.setContent(content);
            autonomicPracticeTeacherListVo.setAutonomousPracticeInfoId(autonomousPracticeInfoId);
            Workbook wb = null;
            if (ext.equals(Wordbook.EXCEL_XLSX)) {
                wb = new XSSFWorkbook();
            } else if (ext.equals(Wordbook.EXCEL_XLS)) {
                wb = new HSSFWorkbook();
            } else {
                wb = new XSSFWorkbook();//保证不为空
            }

            //查询该自主实习下学生填报总数
            AutonomousPracticeInfo autonomousPracticeInfo = autonomousPracticeInfoService.findById(autonomicPracticeTeacherListVo.getAutonomousPracticeInfoId());

            if (ObjectUtils.isEmpty(autonomousPracticeInfo)) {//防止空数据
                return;
            }

            //导出时的文件名
            String exportFileName = "";
            //处理文件名
            if (StringUtils.hasLength(fileName)) {
                fileName = fileName.replaceAll("\\.", "_");//处理文件名
                exportFileName = fileName + "." + ext;
            } else {
                fileName = autonomousPracticeInfo.getAutonomousPracticeTitle().replaceAll("\\.", "_");//处理标题
                exportFileName = fileName + "." + ext;
            }

            Sheet sheet = wb.createSheet(fileName);

            int x = 1;//行 0写入标题
            int y = 0;//列

            //当前用户所有权限
            List<AuthoritiesRecord> authoritiesRecords = authoritiesService.findByUsername(usersService.getUserName());

            //查询出此次自主实习的所有标题
            List<AutonomousPracticeHead> autonomousPracticeHeadRecords = autonomousPracticeHeadService.findByAutonomousPracticeTemplateId(autonomousPracticeInfo.getAutonomousPracticeTemplateId());

            //输出标题
            int hy = 0;//标题列
            Row row = sheet.createRow(0);
            for (AutonomousPracticeHead ah : autonomousPracticeHeadRecords) {
                if (useTitle(ah.getAuthority(), authoritiesRecords)) {//当前用户有权限使用
                    Cell cell = row.createCell(hy);
                    cell.setCellValue(ah.getTitle());
                    hy++;
                }
            }

            Result<Record1<Integer>> record1s = autonomousPracticeContentService.findByAutonomousPracticeInfoIdDistinctStudentId(autonomicPracticeTeacherListVo);
            for (Record r : record1s) {//要查询的学生

                row = sheet.createRow(x);

                //该学生对应的所有标题
                Result<Record> records = autonomousPracticeContentService.findByAutonomousPracticeInfoIdAndStudentId(autonomousPracticeInfo.getId(), r.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.STUDENT_ID));

                for (AutonomousPracticeHead ah : autonomousPracticeHeadRecords) {
                    if (useTitle(ah.getAuthority(), authoritiesRecords)) {//当前用户有权限使用

                        Cell cell = row.createCell(y);

                        boolean hasContent = false;
                        for (Record h : records) {
                            if (ah.getId() == h.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.AUTONOMOUS_PRACTICE_HEAD_ID)) {

                                cell.setCellValue(h.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.CONTENT));

                                hasContent = true;
                                break;
                            }
                        }

                        if (!hasContent) {//未被填写过
                            cell.setCellValue("");
                        }
                        y++;//列加
                    }
                }
                y = 0;//从头开始
                x++;//一个学生完

            }

            //输出文件
            String realPath = request.getSession().getServletContext().getRealPath("/");
            File file = new File(realPath + "/files/autonomicpractice/", exportFileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOut = new
                    FileOutputStream(file);
            wb.write(fileOut);
            fileOut.close();

            //提供下载
            uploadService.download(fileName, "/files/autonomicpractice/" + exportFileName, response, request);

        } catch (FileNotFoundException e) {
            log.error(" file is not found exception is {}", e.getMessage());
        } catch (IOException e) {
            log.error(" exportAutonomicPracticeData is error. exception is {} ", e.getMessage());
        }
    }

    /**
     * 在教师自主实习列表保存数据
     *
     * @param request
     * @return
     */
    @RequestMapping("/teacher/autonomicpractice/addAutonomicPracticeTeacherList")
    @ResponseBody
    public AjaxData addAutonomicPracticeTeacherList(HttpServletRequest request) {
        if (StringUtils.hasLength(request.getParameter("autonomousPracticeInfoId")) && StringUtils.hasLength(request.getParameter("studentId"))) {
            int autonomousPracticeInfoId = Integer.parseInt(request.getParameter("autonomousPracticeInfoId"));
            int studentId = Integer.parseInt(request.getParameter("studentId"));
            saveOrUpdateAutonomousPracticeContent(autonomousPracticeInfoId, studentId, request);
            return new AjaxData().success().msg("保存成功!");
        } else {
            return new AjaxData().fail().msg("参数异常!");
        }

    }

    /**
     * 教师编辑详情
     *
     * @param modelMap
     * @param id        自主实习信息表主键
     * @param studentId 学生id
     * @return
     */
    @RequestMapping("/teacher/autonomicpractice/autonomicPracticeTeacherSingle")
    public String autonomicPracticeTeacherSingle(ModelMap modelMap, @RequestParam("autonomousPracticeInfoId") int id, @RequestParam("studentId") int studentId) {
        AutonomousPracticeInfo autonomousPracticeInfo = autonomousPracticeInfoService.findById(id);

        //当前填报学生的个人信息，用于数据库字段
        Record student = studentService.findByIdWithGrade(studentId);
        AutonomicPracticeStudentInfoVo autonomicPracticeStudentInfoVo = new AutonomicPracticeStudentInfoVo();
        autonomicPracticeStudentInfoVo.setId(student.getValue(Tables.STUDENT.ID));
        autonomicPracticeStudentInfoVo.setStudentNumber(student.getValue(Tables.STUDENT.STUDENT_NUMBER));
        autonomicPracticeStudentInfoVo.setStudentName(student.getValue(Tables.USERS.REAL_NAME));
        autonomicPracticeStudentInfoVo.setStudentPhone(student.getValue(Tables.USERS.MOBILE));
        autonomicPracticeStudentInfoVo.setStudentEmail(student.getValue(Tables.USERS.EMAIL));
        autonomicPracticeStudentInfoVo.setStudentBirthday(student.getValue(Tables.USERS.BIRTHDAY));
        autonomicPracticeStudentInfoVo.setStudentSex(student.getValue(Tables.USERS.SEX));
        autonomicPracticeStudentInfoVo.setStudentIdentityCard(student.getValue(Tables.USERS.IDENTITY_CARD));
        autonomicPracticeStudentInfoVo.setStudentAddress(student.getValue(Tables.USERS.FAMILY_RESIDENCE));
        autonomicPracticeStudentInfoVo.setGradeName(student.getValue(Tables.GRADE.GRADE_NAME));
        modelMap.addAttribute("studentInfo", autonomicPracticeStudentInfoVo);

        //当前填报学生是否已经填报过，若已填报过，则这次视为更新操作
        Result<Record> record5s = autonomousPracticeContentService.findByAutonomousPracticeInfoIdAndStudentId(autonomousPracticeInfo.getId(), studentId);
        if (record5s.isNotEmpty()) {
            List<AutonomousPracticeContent> autonomousPracticeContents = record5s.into(AutonomousPracticeContent.class);
            modelMap.addAttribute("isUpdate", true);
            modelMap.addAttribute("autonomousPracticeContents", autonomousPracticeContents);
        } else {
            modelMap.addAttribute("isUpdate", false);
        }
        //标题信息以及当前用户权限信息
        Result<Record14<Integer, String, String, String, String, String, String, String, Byte, String, Byte, Integer, Byte, Integer>> record14s = autonomousPracticeHeadService.findByAutonomousPracticeTemplateIdWithHeadTypeId(autonomousPracticeInfo.getAutonomousPracticeTemplateId());
        List<AutonomousPracticeHeadAddVo> autonomousPracticeHeadAddVos = new ArrayList<>();

        if (record14s.isNotEmpty()) {
            autonomousPracticeHeadAddVos = record14s.into(AutonomousPracticeHeadAddVo.class);
        }

        List<AuthoritiesRecord> authoritiesRecords = authoritiesService.findByUsername(usersService.getUserName());
        List<Authorities> authoritiesList = new ArrayList<>();
        for (AuthoritiesRecord r : authoritiesRecords) {//视图层无法解析 AuthoritiesRecord对象 ，只能转化一下了
            Authorities authorities = new Authorities(r.getUsername(), r.getAuthority());
            authoritiesList.add(authorities);
        }

        modelMap.addAttribute("heads", autonomousPracticeHeadAddVos);
        modelMap.addAttribute("currentAuthorities", authoritiesList);
        modelMap.addAttribute("autonomousPracticeInfoId", autonomousPracticeInfo.getId());

        return "/teacher/autonomicpractice/autonomicpracticeteachersingle";
    }

    /**
     * 自主实习数据分析
     *
     * @return
     */
    @RequestMapping("/semi/autonomicpractice/dataAnalysis")
    public String dataAnalysis() {
        return "/semi/autonomicpractice/dataanalysis";
    }

    /**
     * 自主实习数据分析 列表页数据
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/semi/autonomicpractice/dataAnalysisData")
    @ResponseBody
    public AjaxData<AutonomicPracticeListVo> dataAnalysisData(int pageNum, int pageSize) {
        //获取当前用户信息
        Record record = usersService.findAll(usersService.getUserName());
        int tieId = 0;
        if (!ObjectUtils.isEmpty(record)) {
            tieId = record.getValue(Tables.TIE.ID);
        }

        //处理数据
        Result<Record11<Integer, String, Timestamp, String, String, Timestamp, Timestamp, String, Integer, Integer, String>> record11s
                = autonomousPracticeInfoService.findByTieIdAndPage(tieId, pageNum, pageSize);
        if (record11s.isNotEmpty()) {
            List<AutonomicPracticeListVo> autonomicPracticeListVos = record11s.into(AutonomicPracticeListVo.class);
            for (AutonomicPracticeListVo autonomicPracticeListVo : autonomicPracticeListVos) {
                autonomicPracticeListVo.setStartTimeString(autonomicPracticeListVo.getStartTime().toString());
                autonomicPracticeListVo.setEndTimeString(autonomicPracticeListVo.getEndTime().toString());
            }
            //分页参数
            PaginationData paginationData = new PaginationData();
            paginationData.setPageSize(pageSize);
            paginationData.setPageNum(pageNum);
            paginationData.setTotalDatas(autonomousPracticeInfoService.findByTieIdAndPageCount(tieId));

            return new AjaxData<AutonomicPracticeListVo>().success().listData(autonomicPracticeListVos).paginationData(paginationData).obj(tieId);
        } else {
            return new AjaxData<AutonomicPracticeListVo>().fail().msg("无数据!");
        }
    }

    /**
     * 自主实习统计页
     *
     * @param autonomousPracticeParam
     * @return
     */
    @RequestMapping("/semi/autonomicpractice/autonomicPracticeCount")
    public String autonomicPracticeCount(@RequestParam("autonomousPracticeParam") String autonomousPracticeParam, ModelMap modelMap) {
        //有哪些年级
        //学生表这些年级学生总数
        //此次自主实习中该年级已提交学生数
        AutonomousPracticeParamVo autonomousPracticeParamVo = JSON.parseObject(autonomousPracticeParam, AutonomousPracticeParamVo.class);
        String[] gradeYears = autonomousPracticeParamVo.getGradeYear().split(",");
        List<AutonomicPracticeCountVo> autonomicPracticeCountVos = new ArrayList<>();
        for (String s : gradeYears) {
            AutonomicPracticeCountVo autonomicPracticeCountVo = new AutonomicPracticeCountVo();
            autonomicPracticeCountVo.setYear(s);
            autonomicPracticeCountVo.setAutonomousPracticeCount(autonomousPracticeContentService.findByAutonomousPracticeInfoIdDistinctStudentIdAndYearCount(autonomousPracticeParamVo.getAutonomousPracticeInfoId(), s));
            autonomicPracticeCountVo.setYearCount(studentService.findByYearAndTieIdCount(s, autonomousPracticeParamVo.getTieId()));
            autonomicPracticeCountVo.setAutonomousPracticeCountNo(autonomicPracticeCountVo.getYearCount() - autonomicPracticeCountVo.getAutonomousPracticeCount());
            autonomicPracticeCountVos.add(autonomicPracticeCountVo);
        }
        modelMap.addAttribute("autonomicPracticeCountVos", autonomicPracticeCountVos);
        modelMap.addAttribute("autonomousPracticeParam", autonomousPracticeParamVo);
        return "/semi/autonomicpractice/autonomicpracticecount";
    }

    /**
     * 以年级统计人员名单
     *
     * @param autonomousPracticeParam
     * @param modelMap
     * @return
     */
    @RequestMapping("/semi/autonomicpractice/autonomicPracticeStudentInfoInYear")
    public String autonomicPracticeStudentInfoInYear(@RequestParam("autonomousPracticeParam") String autonomousPracticeParam, ModelMap modelMap) {
        AutonomousPracticeParamVo autonomousPracticeParamVo = JSON.parseObject(autonomousPracticeParam, AutonomousPracticeParamVo.class);
        modelMap.addAttribute("autonomousPracticeParam", autonomousPracticeParamVo);
        return "/semi/autonomicpractice/autonomicpracticestudentinfoinyear";
    }

    /**
     * 以年级统计人员名单 数据
     *
     * @param autonomousPracticeParamVo
     * @return
     */
    @RequestMapping("/semi/autonomicpractice/autonomicPracticeStudentInfoInYearData")
    @ResponseBody
    public AjaxData autonomicPracticeStudentInfoInYearData(AutonomousPracticeParamVo autonomousPracticeParamVo) {
        List<AutonomicPracticeStudentInfoInYearDataVo> havePayStudent = new ArrayList<>();
        List<AutonomicPracticeStudentInfoInYearDataVo> haveNoPayStudent = new ArrayList<>();

        List<Integer> havePayIds = new ArrayList<>();
        Result<Record1<Integer>> record1s = autonomousPracticeContentService.findByAutonomousPracticeInfoIdDistinctStudentIdAndYear(autonomousPracticeParamVo);
        if (record1s.isNotEmpty()) {
            for (Record r : record1s) {
                havePayIds.add(r.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.STUDENT_ID));
            }
        }

        Result<Record4<Integer, String, String, String>> havePayRecords = studentService.findByYearAndTieIdInStudentId(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds);
        if (havePayRecords.isNotEmpty()) {
            havePayStudent = havePayRecords.into(AutonomicPracticeStudentInfoInYearDataVo.class);
        }

        Result<Record4<Integer, String, String, String>> haveNoPayRecords = studentService.findByYearAndTieIdNotInStudentId(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds);
        if (haveNoPayRecords.isNotEmpty()) {
            haveNoPayStudent = haveNoPayRecords.into(AutonomicPracticeStudentInfoInYearDataVo.class);
        }
        autonomousPracticeParamVo.setHavePayTotalData(studentService.findByYearAndTieIdInStudentIdCount(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds));
        autonomousPracticeParamVo.setHaveNoPayTotalData(studentService.findByYearAndTieIdNotInStudentIdCount(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds));
        Map<String, Object> map = new HashMap<>();
        map.put("havePayStudent", havePayStudent);
        map.put("haveNoPayStudent", haveNoPayStudent);
        map.put("autonomousPracticeParam", autonomousPracticeParamVo);
        return new AjaxData().success().mapData(map);
    }

    /**
     * 导出以年级统计人员名单
     *
     * @param fileName   文件名
     * @param ext        后缀
     * @param jsonData   列表数据
     * @param exportType 列表数据类型 0 已提交 1 未提交
     */
    @RequestMapping("/semi/autonomicpractice/exportAutonomicPracticeStudentInfoInYearData")
    public void exportAutonomicPracticeStudentInfoInYearData(String fileName, @RequestParam(value = "ext", defaultValue = Wordbook.EXCEL_XLSX, required = false) String ext,
                                                             String jsonData, int exportType,HttpServletRequest request,HttpServletResponse response) {
        try{

            String exportFileName = "";
            if (StringUtils.hasLength(fileName)) {
                fileName = fileName.replaceAll("\\.", "_");
                exportFileName = fileName + "." + ext;
            } else {
                if(exportType == 0){
                    fileName = "年级已提交学生名单";
                } else {
                    fileName = "年级未提交学生名单";
                }

                exportFileName = fileName + "." + ext;
            }

            Workbook wb = null;
            if (ext.equals(Wordbook.EXCEL_XLSX)) {
                wb = new HSSFWorkbook();
            } else if (ext.equals(Wordbook.EXCEL_XLS)) {
                wb = new XSSFWorkbook();
            } else {
                wb = new HSSFWorkbook();
            }

            Sheet sheet = wb.createSheet("学生名单");
            int x = 1;//行

            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("学号");
            cell = row.createCell(1);
            cell.setCellValue("姓名");
            cell = row.createCell(2);
            cell.setCellValue("班级");

            if (exportType == 0) {
                List<AutonomicPracticeStudentInfoInYearDataVo> havePayStudent = JSON.parseArray(jsonData, AutonomicPracticeStudentInfoInYearDataVo.class);
                for(AutonomicPracticeStudentInfoInYearDataVo as:havePayStudent){
                    row = sheet.createRow(x);
                    cell = row.createCell(0);
                    cell.setCellValue(as.getStudentNumber());
                    cell = row.createCell(1);
                    cell.setCellValue(as.getStudentName());
                    cell = row.createCell(2);
                    cell.setCellValue(as.getGradeName());
                    x++;
                }

            } else if (exportType == 1) {
                List<AutonomicPracticeStudentInfoInYearDataVo> haveNoPayStudent  = JSON.parseArray(jsonData, AutonomicPracticeStudentInfoInYearDataVo.class);
                for(AutonomicPracticeStudentInfoInYearDataVo as:haveNoPayStudent){
                    row = sheet.createRow(x);
                    cell = row.createCell(0);
                    cell.setCellValue(as.getStudentNumber());
                    cell = row.createCell(1);
                    cell.setCellValue(as.getStudentName());
                    cell = row.createCell(2);
                    cell.setCellValue(as.getGradeName());
                    x++;
                }
            }


            //输出文件
            String realPath = request.getSession().getServletContext().getRealPath("/");
            File file = new File(realPath + "/files/autonomicpracticecount/", exportFileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOut = new
                    FileOutputStream(file);
            wb.write(fileOut);
            fileOut.close();

            //提供下载
            uploadService.download(fileName, "/files/autonomicpracticecount/" + exportFileName, response, request);
        } catch (FileNotFoundException e) {
            log.error(" file is not found exception is {}", e.getMessage());
        } catch (IOException e) {
            log.error(" exportAutonomicPracticeStudentInfoInYearData is error. exception is {} ", e.getMessage());
        }

    }

    /**
     * 自主实习专业统计页
     *
     * @param autonomousPracticeParam
     * @param modelMap
     * @return
     */
    @RequestMapping("/semi/autonomicpractice/autonomicPracticeInMajorCount")
    public String autonomicPracticeInMajorCount(@RequestParam("autonomousPracticeParam") String autonomousPracticeParam, ModelMap modelMap) {
        //查询出该 年级下所有专业id
        AutonomousPracticeParamVo autonomousPracticeParamVo = JSON.parseObject(autonomousPracticeParam, AutonomousPracticeParamVo.class);
        Result<Record2<Integer, String>> record2s = gradeService.findByYearDistinctMajorId(autonomousPracticeParamVo.getYear(), autonomousPracticeParamVo.getTieId());
        List<AutonomicPracticeInMajorCountVo> autonomicPracticeInMajorCountVos = new ArrayList<>();
        for (Record r : record2s) {
            AutonomicPracticeInMajorCountVo autonomicPracticeInMajorCountVo = new AutonomicPracticeInMajorCountVo();
            autonomicPracticeInMajorCountVo.setMajorId(r.getValue(Tables.MAJOR.ID));
            autonomicPracticeInMajorCountVo.setMajorName(r.getValue(Tables.MAJOR.MAJOR_NAME));
            autonomicPracticeInMajorCountVo.setMajorCount(studentService.findByMajorIdCount(r.getValue(Tables.MAJOR.ID), autonomousPracticeParamVo.getYear()));//该专业该年级人数
            autonomicPracticeInMajorCountVo.setAutonomousPracticeCount(autonomousPracticeContentService.findByAutonomousPracticeInfoIdDistinctStudentIdAndMajorIdCount(autonomousPracticeParamVo.getAutonomousPracticeInfoId(), r.getValue(Tables.MAJOR.ID)));//已交人数
            autonomicPracticeInMajorCountVo.setAutonomousPracticeCountNo(autonomicPracticeInMajorCountVo.getMajorCount() - autonomicPracticeInMajorCountVo.getAutonomousPracticeCount());
            autonomicPracticeInMajorCountVos.add(autonomicPracticeInMajorCountVo);
        }
        modelMap.addAttribute("autonomicPracticeInMajorCountVos", autonomicPracticeInMajorCountVos);
        modelMap.addAttribute("autonomousPracticeParam", autonomousPracticeParamVo);
        return "/semi/autonomicpractice/autonomicpracticeinmajorcount";
    }

    /**
     * 以专业统计人员名单
     *
     * @param autonomousPracticeParam
     * @param modelMap
     * @return
     */
    @RequestMapping("/semi/autonomicpractice/autonomicPracticeStudentInfoInMajor")
    public String autonomicPracticeStudentInfoInMajor(@RequestParam("autonomousPracticeParam") String autonomousPracticeParam, ModelMap modelMap) {
        AutonomousPracticeParamVo autonomousPracticeParamVo = JSON.parseObject(autonomousPracticeParam, AutonomousPracticeParamVo.class);
        modelMap.addAttribute("autonomousPracticeParam", autonomousPracticeParamVo);
        return "/semi/autonomicpractice/autonomicpracticestudentinfoinmajor";
    }

    /**
     * 以专业统计人员名单 数据
     *
     * @param autonomousPracticeParamVo
     * @return
     */
    @RequestMapping("/semi/autonomicpractice/autonomicPracticeStudentInfoInMajorData")
    @ResponseBody
    public AjaxData autonomicPracticeStudentInfoInMajorData(AutonomousPracticeParamVo autonomousPracticeParamVo) {
        List<AutonomicPracticeStudentInfoInMajorDataVo> havePayStudent = new ArrayList<>();
        List<AutonomicPracticeStudentInfoInMajorDataVo> haveNoPayStudent = new ArrayList<>();

        List<Integer> havePayIds = new ArrayList<>();
        Result<Record1<Integer>> record1s = autonomousPracticeContentService.findByAutonomousPracticeInfoIdDistinctStudentIdAndMajorIdAndYear(autonomousPracticeParamVo);
        if (record1s.isNotEmpty()) {
            for (Record r : record1s) {
                havePayIds.add(r.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.STUDENT_ID));
            }
        }

        Result<Record4<Integer, String, String, String>> havePayRecords = studentService.findByMajorIdAndTieIdAndYearInStudentId(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds);
        if (havePayRecords.isNotEmpty()) {
            havePayStudent = havePayRecords.into(AutonomicPracticeStudentInfoInMajorDataVo.class);
        }

        Result<Record4<Integer, String, String, String>> haveNoPayRecords = studentService.findByMajorIdAndTieIdAndYearNotInStudentId(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds);
        if (haveNoPayRecords.isNotEmpty()) {//未提交人从这里分页
            haveNoPayStudent = haveNoPayRecords.into(AutonomicPracticeStudentInfoInMajorDataVo.class);
        }
        autonomousPracticeParamVo.setHavePayTotalData(studentService.findByMajorIdAndTieIdAndYearInStudentIdCount(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds));
        autonomousPracticeParamVo.setHaveNoPayTotalData(studentService.findByMajorIdAndTieIdAndYearNotInStudentIdCount(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds));
        Map<String, Object> map = new HashMap<>();
        map.put("havePayStudent", havePayStudent);
        map.put("haveNoPayStudent", haveNoPayStudent);
        map.put("autonomousPracticeParam", autonomousPracticeParamVo);
        return new AjaxData().success().mapData(map);
    }

    /**
     * 导出以专业统计人员名单
     *
     * @param fileName   文件名
     * @param ext        后缀
     * @param jsonData   列表数据
     * @param exportType 列表数据类型 0 已提交 1 未提交
     */
    @RequestMapping("/semi/autonomicpractice/exportAutonomicPracticeStudentInfoInMajorData")
    public void exportAutonomicPracticeStudentInfoInMajorData(String fileName, @RequestParam(value = "ext", defaultValue = Wordbook.EXCEL_XLSX, required = false) String ext,
                                                              String jsonData, int exportType,HttpServletRequest request,HttpServletResponse response){
        try{

            String exportFileName = "";
            if (StringUtils.hasLength(fileName)) {
                fileName = fileName.replaceAll("\\.", "_");
                exportFileName = fileName + "." + ext;
            } else {
                if(exportType == 0){
                    fileName = "专业已提交学生名单";
                } else {
                    fileName = "专业未提交学生名单";
                }

                exportFileName = fileName + "." + ext;
            }

            Workbook wb = null;
            if (ext.equals(Wordbook.EXCEL_XLSX)) {
                wb = new HSSFWorkbook();
            } else if (ext.equals(Wordbook.EXCEL_XLS)) {
                wb = new XSSFWorkbook();
            } else {
                wb = new HSSFWorkbook();
            }

            Sheet sheet = wb.createSheet("学生名单");
            int x = 1;//行

            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("学号");
            cell = row.createCell(1);
            cell.setCellValue("姓名");
            cell = row.createCell(2);
            cell.setCellValue("班级");

            if (exportType == 0) {
                List<AutonomicPracticeStudentInfoInMajorDataVo> havePayStudent = JSON.parseArray(jsonData, AutonomicPracticeStudentInfoInMajorDataVo.class);
                for(AutonomicPracticeStudentInfoInMajorDataVo as:havePayStudent){
                    row = sheet.createRow(x);
                    cell = row.createCell(0);
                    cell.setCellValue(as.getStudentNumber());
                    cell = row.createCell(1);
                    cell.setCellValue(as.getStudentName());
                    cell = row.createCell(2);
                    cell.setCellValue(as.getGradeName());
                    x++;
                }

            } else if (exportType == 1) {
                List<AutonomicPracticeStudentInfoInMajorDataVo> haveNoPayStudent  = JSON.parseArray(jsonData, AutonomicPracticeStudentInfoInMajorDataVo.class);
                for(AutonomicPracticeStudentInfoInMajorDataVo as:haveNoPayStudent){
                    row = sheet.createRow(x);
                    cell = row.createCell(0);
                    cell.setCellValue(as.getStudentNumber());
                    cell = row.createCell(1);
                    cell.setCellValue(as.getStudentName());
                    cell = row.createCell(2);
                    cell.setCellValue(as.getGradeName());
                    x++;
                }
            }


            //输出文件
            String realPath = request.getSession().getServletContext().getRealPath("/");
            File file = new File(realPath + "/files/autonomicpracticecount/", exportFileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOut = new
                    FileOutputStream(file);
            wb.write(fileOut);
            fileOut.close();

            //提供下载
            uploadService.download(fileName, "/files/autonomicpracticecount/" + exportFileName, response, request);
        } catch (FileNotFoundException e) {
            log.error(" file is not found exception is {}", e.getMessage());
        } catch (IOException e) {
            log.error(" exportAutonomicPracticeStudentInfoInYearData is error. exception is {} ", e.getMessage());
        }
    }

    /**
     * 自主实习班级统计页
     *
     * @param autonomousPracticeParam
     * @return
     */
    @RequestMapping("/semi/autonomicpractice/autonomicPracticeInGradeCount")
    public String autonomicPracticeInGradeCount(@RequestParam("autonomousPracticeParam") String autonomousPracticeParam, ModelMap modelMap) {
        //查询出该 专业下所有班级id
        AutonomousPracticeParamVo autonomousPracticeParamVo = JSON.parseObject(autonomousPracticeParam, AutonomousPracticeParamVo.class);
        Result<Record2<Integer, String>> record2s = gradeService.findByMajorIdAndYear(autonomousPracticeParamVo.getMajorId(), autonomousPracticeParamVo.getYear());
        List<AutonomicPracticeInGradeCountVo> autonomicPracticeInGradeCountVos = new ArrayList<>();
        for (Record r : record2s) {
            AutonomicPracticeInGradeCountVo autonomicPracticeInGradeCountVo = new AutonomicPracticeInGradeCountVo();
            autonomicPracticeInGradeCountVo.setGradeId(r.getValue(Tables.GRADE.ID));
            autonomicPracticeInGradeCountVo.setGradeName(r.getValue(Tables.GRADE.GRADE_NAME));
            autonomicPracticeInGradeCountVo.setGradeCount(studentService.findByGradeIdCount(r.getValue(Tables.GRADE.ID)));
            autonomicPracticeInGradeCountVo.setAutonomousPracticeCount(autonomousPracticeContentService.findByAutonomousPracticeInfoIdDistinctStudentIdAndGradeIdCount(autonomousPracticeParamVo.getAutonomousPracticeInfoId(), r.getValue(Tables.GRADE.ID)));
            autonomicPracticeInGradeCountVo.setAutonomousPracticeCountNo(autonomicPracticeInGradeCountVo.getGradeCount() - autonomicPracticeInGradeCountVo.getAutonomousPracticeCount());
            autonomicPracticeInGradeCountVos.add(autonomicPracticeInGradeCountVo);
        }
        modelMap.addAttribute("autonomicPracticeInGradeCountVos", autonomicPracticeInGradeCountVos);
        modelMap.addAttribute("autonomousPracticeParam", autonomousPracticeParamVo);
        return "/semi/autonomicpractice/autonomicpracticeingradecount";
    }

    /**
     * 以班级统计人员名单
     *
     * @param autonomousPracticeParam
     * @param modelMap
     * @return
     */
    @RequestMapping("/semi/autonomicpractice/autonomicPracticeStudentInfoInGrade")
    public String autonomicPracticeStudentInfoInGrade(@RequestParam("autonomousPracticeParam") String autonomousPracticeParam, ModelMap modelMap) {
        AutonomousPracticeParamVo autonomousPracticeParamVo = JSON.parseObject(autonomousPracticeParam, AutonomousPracticeParamVo.class);
        modelMap.addAttribute("autonomousPracticeParam", autonomousPracticeParamVo);
        return "/semi/autonomicpractice/autonomicpracticestudentinfoingrade";
    }

    /**
     * 以班级统计人员名单 数据
     *
     * @param autonomousPracticeParamVo
     * @return
     */
    @RequestMapping("/semi/autonomicpractice/autonomicPracticeStudentInfoInGradeData")
    @ResponseBody
    public AjaxData autonomicPracticeStudentInfoInGradeData(AutonomousPracticeParamVo autonomousPracticeParamVo) {
        List<AutonomicPracticeStudentInfoInGradeDataVo> havePayStudent = new ArrayList<>();
        List<AutonomicPracticeStudentInfoInGradeDataVo> haveNoPayStudent = new ArrayList<>();

        List<Integer> havePayIds = new ArrayList<>();
        Result<Record1<Integer>> record1s = autonomousPracticeContentService.findByAutonomousPracticeInfoIdDistinctStudentIdAndGradeIdAndYear(autonomousPracticeParamVo);
        if (record1s.isNotEmpty()) {
            for (Record r : record1s) {
                havePayIds.add(r.getValue(Tables.AUTONOMOUS_PRACTICE_CONTENT.STUDENT_ID));
            }
        }

        Result<Record4<Integer, String, String, String>> havePayRecords = studentService.findByGradeIdIdAndTieIdAndYearInStudentId(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds);
        if (havePayRecords.isNotEmpty()) {
            havePayStudent = havePayRecords.into(AutonomicPracticeStudentInfoInGradeDataVo.class);
        }

        Result<Record4<Integer, String, String, String>> haveNoPayRecords = studentService.findByGradeIdAndTieIdAndYearNotInStudentId(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds);
        if (haveNoPayRecords.isNotEmpty()) {//未提交人从这里分页
            haveNoPayStudent = haveNoPayRecords.into(AutonomicPracticeStudentInfoInGradeDataVo.class);
        }
        autonomousPracticeParamVo.setHavePayTotalData(studentService.findByGradeIdIdAndTieIdAndYearInStudentIdCount(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds));
        autonomousPracticeParamVo.setHaveNoPayTotalData(studentService.findByGradeIdAndTieIdAndYearNotInStudentIdCount(autonomousPracticeParamVo, autonomousPracticeParamVo.getTieId(), havePayIds));
        Map<String, Object> map = new HashMap<>();
        map.put("havePayStudent", havePayStudent);
        map.put("haveNoPayStudent", haveNoPayStudent);
        map.put("autonomousPracticeParam", autonomousPracticeParamVo);
        return new AjaxData().success().mapData(map);
    }

    /**
     * 导出以专业统计人员名单
     *
     * @param fileName   文件名
     * @param ext        后缀
     * @param jsonData   列表数据
     * @param exportType 列表数据类型 0 已提交 1 未提交
     */
    @RequestMapping("/semi/autonomicpractice/exportAutonomicPracticeStudentInfoInGradeData")
    public void exportAutonomicPracticeStudentInfoInGradeData(String fileName, @RequestParam(value = "ext", defaultValue = Wordbook.EXCEL_XLSX, required = false) String ext,
                                                              String jsonData, int exportType,HttpServletRequest request,HttpServletResponse response){
        try{

            String exportFileName = "";
            if (StringUtils.hasLength(fileName)) {
                fileName = fileName.replaceAll("\\.", "_");
                exportFileName = fileName + "." + ext;
            } else {
                if(exportType == 0){
                    fileName = "班级已提交学生名单";
                } else {
                    fileName = "班级未提交学生名单";
                }

                exportFileName = fileName + "." + ext;
            }

            Workbook wb = null;
            if (ext.equals(Wordbook.EXCEL_XLSX)) {
                wb = new HSSFWorkbook();
            } else if (ext.equals(Wordbook.EXCEL_XLS)) {
                wb = new XSSFWorkbook();
            } else {
                wb = new HSSFWorkbook();
            }

            Sheet sheet = wb.createSheet("学生名单");
            int x = 1;//行

            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("学号");
            cell = row.createCell(1);
            cell.setCellValue("姓名");
            cell = row.createCell(2);
            cell.setCellValue("班级");

            if (exportType == 0) {
                List<AutonomicPracticeStudentInfoInGradeDataVo> havePayStudent = JSON.parseArray(jsonData, AutonomicPracticeStudentInfoInGradeDataVo.class);
                for(AutonomicPracticeStudentInfoInGradeDataVo as:havePayStudent){
                    row = sheet.createRow(x);
                    cell = row.createCell(0);
                    cell.setCellValue(as.getStudentNumber());
                    cell = row.createCell(1);
                    cell.setCellValue(as.getStudentName());
                    cell = row.createCell(2);
                    cell.setCellValue(as.getGradeName());
                    x++;
                }

            } else if (exportType == 1) {
                List<AutonomicPracticeStudentInfoInGradeDataVo> haveNoPayStudent  = JSON.parseArray(jsonData, AutonomicPracticeStudentInfoInGradeDataVo.class);
                for(AutonomicPracticeStudentInfoInGradeDataVo as:haveNoPayStudent){
                    row = sheet.createRow(x);
                    cell = row.createCell(0);
                    cell.setCellValue(as.getStudentNumber());
                    cell = row.createCell(1);
                    cell.setCellValue(as.getStudentName());
                    cell = row.createCell(2);
                    cell.setCellValue(as.getGradeName());
                    x++;
                }
            }


            //输出文件
            String realPath = request.getSession().getServletContext().getRealPath("/");
            File file = new File(realPath + "/files/autonomicpracticecount/", exportFileName);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOut = new
                    FileOutputStream(file);
            wb.write(fileOut);
            fileOut.close();

            //提供下载
            uploadService.download(fileName, "/files/autonomicpracticecount/" + exportFileName, response, request);
        } catch (FileNotFoundException e) {
            log.error(" file is not found exception is {}", e.getMessage());
        } catch (IOException e) {
            log.error(" exportAutonomicPracticeStudentInfoInYearData is error. exception is {} ", e.getMessage());
        }
    }

    /**
     * 是否有权限使用title
     *
     * @param headsAuthority
     * @param authoritiesRecords
     * @return
     */
    private boolean useTitle(String headsAuthority, List<AuthoritiesRecord> authoritiesRecords) {
        String[] authorities = headsAuthority.split(",");
        boolean isRight = false;
        if (!authoritiesRecords.isEmpty()) {
            for (int i = 0; i < authoritiesRecords.size(); i++) {
                for (int j = 0; j < authorities.length; j++) {
                    if (authoritiesRecords.get(i).getAuthority().equals(authorities[j])) {
                        isRight = true;
                        break;
                    }
                }
                if (isRight) {
                    break;
                }
            }
        }
        return isRight;
    }

    /**
     * 组装 AutonomousPracticeContent
     *
     * @param ap
     * @param ac
     * @param request
     */
    private void assembleAutonomousPracticeContent(Record ap, AutonomousPracticeContent ac, HttpServletRequest request) {
        if (ap.getValue(Tables.HEAD_TYPE.TYPE_VALUE).equals("switch")) {
            String[] temp = ap.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.CONTENT).split(",");
            if (StringUtils.hasLength(request.getParameter(ap.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.TITLE_VARIABLE))) && temp.length == 2) {
                if (request.getParameter(ap.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.TITLE_VARIABLE)).equals("on")) {
                    ac.setContent(temp[0]);
                } else {
                    ac.setContent(temp[0]);
                }
            } else {
                ac.setContent(temp[1]);
            }
        } else if (ap.getValue(Tables.HEAD_TYPE.TYPE_VALUE).equals("checkbox")) {
            String[] temp = request.getParameterValues(ap.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.TITLE_VARIABLE));
            if (!ObjectUtils.isEmpty(temp) && temp.length > 0) {
                String s = "";
                for (String st : temp) {
                    s = s + st + ",";
                }
                s = s.substring(0, s.lastIndexOf(","));
                ac.setContent(s);
            } else {
                ac.setContent(null);
            }
        } else {
            ac.setContent(request.getParameter(ap.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.TITLE_VARIABLE)));
        }
    }

    private void saveOrUpdateAutonomousPracticeContent(int autonomousPracticeInfoId, int studentId, HttpServletRequest request) {
        AutonomousPracticeInfo autonomousPracticeInfo = autonomousPracticeInfoService.findById(autonomousPracticeInfoId);
        Result<Record14<Integer, String, String, String, String, String, String, String, Byte, String, Byte, Integer, Byte, Integer>> record14s =
                autonomousPracticeHeadService.findByAutonomousPracticeTemplateIdWithHeadTypeId(autonomousPracticeInfo.getAutonomousPracticeTemplateId());
        if (record14s.isNotEmpty()) {
            List<AuthoritiesRecord> authoritiesRecords = authoritiesService.findByUsername(usersService.getUserName());
            //自主实习可能对应多个相同的templateId 应该按照自主实习信息表id查询
            Result<Record> record5s = autonomousPracticeContentService.findByAutonomousPracticeInfoIdAndStudentId(autonomousPracticeInfoId, studentId);
            if (record5s.isNotEmpty() && record5s.size() == record14s.size()) {//更新操作 标题数据与数据数一样
                List<AutonomousPracticeContent> autonomousPracticeContents = record5s.into(AutonomousPracticeContent.class);
                for (Record ap : record14s) {
                    if (useTitle(ap.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.AUTHORITY), authoritiesRecords)) {
                        for (AutonomousPracticeContent ac : autonomousPracticeContents) {
                            if (ac.getAutonomousPracticeHeadId() == ap.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.ID)) {
                                //不检查是否必填了，由前端检验了
                                assembleAutonomousPracticeContent(ap, ac, request);
                                ac.setStudentId(studentId);
                                ac.setAutonomousPracticeInfoId(autonomousPracticeInfoId);
                                ac.setAutonomousPracticeHeadId(ap.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.ID));
                                autonomousPracticeContentService.update(ac);
                                break;
                            }
                        }
                    }//没有权限也不用更新了，有就可以了
                }
            } else {//保存操作
                //要先删除以前的数据  删除后分页就不对了，只能在学生插入或更新信息时全部插入标题到content表中了
                for (Record ap : record14s) {
                    autonomousPracticeContentService.deleteByAutonomousPracticeHeadIdAndStudentId(ap.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.ID), studentId);
                }
                //进行保存
                for (Record ap : record14s) {
                    //不检查是否必填了，由前端检验了
                    AutonomousPracticeContent autonomousPracticeContent = new AutonomousPracticeContent();
                    autonomousPracticeContent.setAutonomousPracticeHeadId(ap.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.ID));
                    autonomousPracticeContent.setStudentId(studentId);
                    autonomousPracticeContent.setAutonomousPracticeInfoId(autonomousPracticeInfoId);
                    if (useTitle(ap.getValue(Tables.AUTONOMOUS_PRACTICE_HEAD.AUTHORITY), authoritiesRecords)) {
                        assembleAutonomousPracticeContent(ap, autonomousPracticeContent, request);
                        autonomousPracticeContentService.save(autonomousPracticeContent);
                    } else {
                        autonomousPracticeContentService.save(autonomousPracticeContent);
                    }
                }
            }
        }
    }
}
