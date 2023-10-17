package com.webbdong.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author WebbDong
 * @createTime 2023-10-17 00:43
 */
@Data
@Document(indexName = "virtual-character")
public class VirtualCharacter implements Serializable {

    /**
     * 主键id
     */
    @Id
    private Long id;

    /**
     * siya id
     */
    private String siyaId;

    /**
     * 性别, 0:男, 1:女
     */
    private Integer gender;

    /**
     * 名字
     */
    private String name;

    /**
     * 个性tag
     */
    private String tag;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 角色类型
     */
    private Integer roleType;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 太阳星座
     */
    private Integer sunSign;

    /**
     * 月亮星座
     */
    private Integer moonSign;

    /**
     * 上升星座
     */
    private Integer ascendant;

    /**
     * MBTI设置
     */
    private String mbti;

    /**
     * 语言风格，多个用英文$符号分割
     */
    private String languageStyle;

    /**
     * 温度-控制模型对问题回答的自我发挥程度
     */
    private String temperature;

    /**
     * 交互语言，虚拟人交互时返回的语言与语音的语言
     */
    private String interactiveLanguage;

}
