package com.example.dteam_dpots.DatabaseContext;
import com.example.dteam_dpots.Beans.*;

import com.example.dteam_dpots.Beans.Income;

import java.util.Arrays;
import java.util.List;

public class DAO {
//cau lenh query excute sql
    public DAO() {
    }

    public List<Income> getIncomeList() {
        Income[] incomeList = {new Income("Month", 1000D), new Income("Month", 2000D), new Income("Month", 3000D)};
        return Arrays.asList(incomeList);
    }
}