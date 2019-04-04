package com.example.demo.excel;

import com.example.demo.bean.Stu;
import com.example.demo.db.DBhelper;
import com.example.demo.service.StuService;

import java.util.List;

public class FromExcelToDb {
    public static void main(String[] args) {
        //得到表格中所有的数据
        List<Stu> listExcel= StuService.getAllByExcel("d://book.xls");
        /*//得到数据库表中所有的数据
        List<Stu> listDb=StuService.getAllByDb();*/

        DBhelper db=new DBhelper();

        for (Stu stuEntity : listExcel) {
            int id=stuEntity.getId();
            if (!StuService.isExist(id)) {
                //不存在就添加
                String sql="insert into student (name,sex,num) values(?,?,?)";
                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+""};
                db.AddU(sql, str);
            }else {
                //存在就更新
                String sql="update student set name=?,sex=?,num=? where id=?";
                String[] str=new String[]{stuEntity.getName(),stuEntity.getSex(),stuEntity.getNum()+"",id+""};
                db.AddU(sql, str);
            }
        }
        System.out.println("数据更新成功！");
    }
}