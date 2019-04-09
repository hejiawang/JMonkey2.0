package com.wang.jmonkey.test.modules.ieg;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wang.jmonkey.JmonkeyApplication;
import com.wang.jmonkey.common.utils.poi.excel.ImportExcelUtil;
import com.wang.jmonkey.modules.ieg.model.entity.IegSchool;
import com.wang.jmonkey.modules.ieg.model.entity.IegSchoolSubmit;
import com.wang.jmonkey.modules.ieg.model.enums.IegDegreeTypeEnums;
import com.wang.jmonkey.modules.ieg.service.IIegSchoolMajorService;
import com.wang.jmonkey.modules.ieg.service.IIegSchoolService;
import com.wang.jmonkey.modules.ieg.service.IIegSchoolSubmitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.List;

/**
 * 导入院校信息
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JmonkeyApplication.class)
public class ImportSchoolTest {

    @Autowired
    private IIegSchoolService schoolService;

    @Autowired
    private IIegSchoolSubmitService submitService;

    @Autowired
    private IIegSchoolMajorService majorService;

    @Test
    public void importSchool() throws Exception {
        File file = new File("E://temp.xlsx");
        ImportExcelUtil ei = new ImportExcelUtil(file, 0);
        List<ImportSchoolParam> list = ei.getDataList(ImportSchoolParam.class);

        list.forEach( param -> {
            // 处理院校信息
            IegSchool schoolInfo = renderSchool(param);

            // 处理投档单位信息
            IegSchoolSubmit submitInfo = this.renderSubmit(schoolInfo, param);

            // 处理专业信息


        });
    }

    /**
     * 构建投档单位信息
     * @param schoolInfo
     * @param param
     * @return
     */
    private IegSchoolSubmit renderSubmit(IegSchool schoolInfo, ImportSchoolParam param) {
        if (param.getTddwmc().indexOf("院校代号:") != -1) {
            // 获取Excel中投档单位code
            int index = param.getTddwmc().indexOf("院校代号:") + 5;
            String code = param.getTddwmc().substring(index);
            if (param.getTddwmc().indexOf("院校名称") != -1) code = code.substring(0, code.indexOf("院校名称"));
            code = code.trim();

            // 维护投档单位信息
            IegSchoolSubmit submit =  new IegSchoolSubmit().setCode(code).setSchoolId(schoolInfo.getId());
            EntityWrapper<IegSchoolSubmit> submitWrapper = new EntityWrapper<>();
            submitWrapper.setEntity(submit);
            IegSchoolSubmit submitInfo = submitService.selectOne(submitWrapper);
            if (submitInfo == null) {
                submitService.insert(submit);
                return submit;
            } else {
                return submitInfo;
            }
        }

        return null;
    }

    /**
     * 处理院校信息
     * @param param
     * @return
     */
    private IegSchool renderSchool(ImportSchoolParam param) {
        // 获取院校名称
        int index = 0;
        if (param.getTddwmc().indexOf("院校名称:") != -1) index = param.getTddwmc().indexOf("院校名称:") + 5;
        String name = param.getTddwmc().substring(index);
        if (name.indexOf("批次") != -1) name = name.substring(0, name.indexOf("批次"));
        name = name.trim();

        // 判断院校是否已经存在
        EntityWrapper<IegSchool> schoolWrapper = new EntityWrapper<>();
        schoolWrapper.setEntity(new IegSchool().setName(name));

        IegSchool schoolInfo = schoolService.selectOne(schoolWrapper);
        if (schoolInfo == null) { //如果院校不存在，新建院校
            schoolInfo = new IegSchool().setName(name).setCode(param.getYxdh());
            if (param.getPcdm().equals("3")) schoolInfo.setDegreeType(IegDegreeTypeEnums.B);
            if (param.getPcdm().equals("7")) schoolInfo.setDegreeType(IegDegreeTypeEnums.Z);

            schoolService.insert(schoolInfo);
        } else {    //院校信息已经存在
            // 更新院校学历层次信息
            if (schoolInfo.getDegreeType() == null) {
                if (param.getPcdm().equals("3")) schoolInfo.setDegreeType(IegDegreeTypeEnums.B);
                if (param.getPcdm().equals("7")) schoolInfo.setDegreeType(IegDegreeTypeEnums.Z);

                schoolService.updateById(schoolInfo);
            } else {
                if ((param.getPcdm().equals("7") && schoolInfo.getDegreeType() == IegDegreeTypeEnums.B) ||
                        (param.getPcdm().equals("3") && schoolInfo.getDegreeType() == IegDegreeTypeEnums.Z) ) {
                    schoolInfo.setDegreeType(IegDegreeTypeEnums.A);

                    schoolService.updateById(schoolInfo);
                }
            }
        }

        return schoolInfo;
    }
}
