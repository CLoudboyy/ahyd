package cn.edu.guet.mapper;

import cn.edu.guet.bean.PlanDesignCadDrawing;
import cn.edu.guet.bean.PlanDesignCadDrawingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PlanDesignCadDrawingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    long countByExample(PlanDesignCadDrawingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    int deleteByExample(PlanDesignCadDrawingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    int insert(PlanDesignCadDrawing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    int insertSelective(PlanDesignCadDrawing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    List<PlanDesignCadDrawing> selectByExampleWithRowbounds(PlanDesignCadDrawingExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    List<PlanDesignCadDrawing> selectByExample(PlanDesignCadDrawingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    PlanDesignCadDrawing selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    int updateByExampleSelective(@Param("record") PlanDesignCadDrawing record, @Param("example") PlanDesignCadDrawingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    int updateByExample(@Param("record") PlanDesignCadDrawing record, @Param("example") PlanDesignCadDrawingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    int updateByPrimaryKeySelective(PlanDesignCadDrawing record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_plan_design_cad_drawing
     *
     * @mbg.generated Wed Jun 21 17:13:06 CST 2023
     */
    int updateByPrimaryKey(PlanDesignCadDrawing record);
}