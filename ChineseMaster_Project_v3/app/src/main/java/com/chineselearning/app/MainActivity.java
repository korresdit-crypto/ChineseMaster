package com.chineselearning.app;

import android.app.Activity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import java.util.*;

public class MainActivity extends Activity {
    LinearLayout root;
    SharedPreferences prefs;
    Random random = new Random();
    String currentMode = "radicals";
    int currentIndex = 0;

    static final int BG = Color.rgb(255, 248, 240);
    static final int CARD = Color.rgb(255, 236, 219);
    static final int INK = Color.rgb(45, 38, 32);
    static final int ACCENT = Color.rgb(178, 69, 36);

    static final String[] RADICALS = {
        "№1  一\\nPinyin: yī\\nЗначение: один\\nПримеры: 一, 丁, 七",
        "№2  丨\\nPinyin: gǔn\\nЗначение: вертикальная черта\\nПримеры: 中, 串, 丰",
        "№3  丶\\nPinyin: zhǔ\\nЗначение: точка\\nПримеры: 丸, 丹, 主",
        "№4  丿\\nPinyin: piě\\nЗначение: наклонная черта\\nПримеры: 乃, 久, 乂",
        "№5  乙\\nPinyin: yǐ\\nЗначение: второй; изгиб\\nПримеры: 九, 也, 乾",
        "№6  亅\\nPinyin: jué\\nЗначение: крюк\\nПримеры: 了, 事, 予",
        "№7  二\\nPinyin: èr\\nЗначение: два\\nПримеры: 二, 云, 五",
        "№8  亠\\nPinyin: tóu\\nЗначение: крышка\\nПримеры: 亡, 交, 京",
        "№9  人\\nPinyin: rén\\nЗначение: человек\\nПримеры: 人, 仁, 今",
        "№10  儿\\nPinyin: ér\\nЗначение: ноги человека\\nПримеры: 儿, 兄, 先",
        "№11  入\\nPinyin: rù\\nЗначение: входить\\nПримеры: 入, 內, 全",
        "№12  八\\nPinyin: bā\\nЗначение: восемь; разделение\\nПримеры: 八, 公, 六",
        "№13  冂\\nPinyin: jiōng\\nЗначение: граница; далёкое\\nПримеры: 冂, 冊, 再",
        "№14  冖\\nPinyin: mì\\nЗначение: покрывало\\nПримеры: 写, 冠, 冥",
        "№15  冫\\nPinyin: bīng\\nЗначение: лёд\\nПримеры: 冰, 冷, 准",
        "№16  几\\nPinyin: jī\\nЗначение: столик\\nПримеры: 几, 凡, 凭",
        "№17  凵\\nPinyin: kǎn\\nЗначение: яма; короб\\nПримеры: 凶, 出, 函",
        "№18  刀\\nPinyin: dāo\\nЗначение: нож\\nПримеры: 刀, 分, 切",
        "№19  力\\nPinyin: lì\\nЗначение: сила\\nПримеры: 力, 功, 加",
        "№20  勹\\nPinyin: bāo\\nЗначение: обёртывать\\nПримеры: 勺, 包, 匀",
        "№21  匕\\nPinyin: bǐ\\nЗначение: ложка; кинжал\\nПримеры: 化, 北, 匙",
        "№22  匚\\nPinyin: fāng\\nЗначение: короб\\nПримеры: 匠, 匡, 匣",
        "№23  匸\\nPinyin: xǐ\\nЗначение: прятать\\nПримеры: 匹, 区, 医",
        "№24  十\\nPinyin: shí\\nЗначение: десять\\nПримеры: 十, 千, 升",
        "№25  卜\\nPinyin: bǔ\\nЗначение: гадание\\nПримеры: 卜, 占, 卦",
        "№26  卩\\nPinyin: jié\\nЗначение: печать\\nПримеры: 卯, 印, 即",
        "№27  厂\\nPinyin: chǎng\\nЗначение: обрыв; склон\\nПримеры: 厂, 厅, 原",
        "№28  厶\\nPinyin: sī\\nЗначение: частный\\nПримеры: 厶, 去, 参",
        "№29  又\\nPinyin: yòu\\nЗначение: снова; правая рука\\nПримеры: 又, 友, 取",
        "№30  口\\nPinyin: kǒu\\nЗначение: рот\\nПримеры: 口, 叫, 吃",
        "№31  囗\\nPinyin: wéi\\nЗначение: ограда\\nПримеры: 囚, 四, 国",
        "№32  土\\nPinyin: tǔ\\nЗначение: земля\\nПримеры: 土, 地, 坐",
        "№33  士\\nPinyin: shì\\nЗначение: учёный; воин\\nПримеры: 士, 壮, 声",
        "№34  夂\\nPinyin: zhǐ\\nЗначение: идти; приходить\\nПримеры: 处, 冬, 备",
        "№35  夊\\nPinyin: suī\\nЗначение: медленно идти\\nПримеры: 夊, 夏, 复",
        "№36  夕\\nPinyin: xī\\nЗначение: вечер\\nПримеры: 夕, 外, 多",
        "№37  大\\nPinyin: dà\\nЗначение: большой\\nПримеры: 大, 天, 太",
        "№38  女\\nPinyin: nǚ\\nЗначение: женщина\\nПримеры: 女, 好, 妈",
        "№39  子\\nPinyin: zǐ\\nЗначение: ребёнок\\nПримеры: 子, 字, 孙",
        "№40  宀\\nPinyin: mián\\nЗначение: крыша\\nПримеры: 安, 家, 室",
        "№41  寸\\nPinyin: cùn\\nЗначение: вершок; мера\\nПримеры: 寸, 对, 寺",
        "№42  小\\nPinyin: xiǎo\\nЗначение: маленький\\nПримеры: 小, 少, 尔",
        "№43  尢\\nPinyin: wāng\\nЗначение: хромой\\nПримеры: 尤, 就, 尴",
        "№44  尸\\nPinyin: shī\\nЗначение: тело; труп\\nПримеры: 尸, 尺, 居",
        "№45  屮\\nPinyin: chè\\nЗначение: росток\\nПримеры: 屮, 屯, 屈",
        "№46  山\\nPinyin: shān\\nЗначение: гора\\nПримеры: 山, 岁, 岛",
        "№47  巛\\nPinyin: chuān\\nЗначение: река\\nПримеры: 巡, 巢, 州",
        "№48  工\\nPinyin: gōng\\nЗначение: работа\\nПримеры: 工, 左, 巧",
        "№49  己\\nPinyin: jǐ\\nЗначение: сам; уже\\nПримеры: 己, 已, 巳",
        "№50  巾\\nPinyin: jīn\\nЗначение: ткань\\nПримеры: 巾, 市, 师",
        "№51  干\\nPinyin: gān\\nЗначение: сухой; щит\\nПримеры: 干, 平, 年",
        "№52  幺\\nPinyin: yāo\\nЗначение: малый; нить\\nПримеры: 幼, 幻, 幾",
        "№53  广\\nPinyin: guǎng\\nЗначение: навес\\nПримеры: 广, 床, 店",
        "№54  廴\\nPinyin: yǐn\\nЗначение: длинный шаг\\nПримеры: 延, 建, 廷",
        "№55  廾\\nPinyin: gǒng\\nЗначение: две руки\\nПримеры: 开, 异, 弊",
        "№56  弋\\nPinyin: yì\\nЗначение: стрела с верёвкой\\nПримеры: 弋, 式, 弑",
        "№57  弓\\nPinyin: gōng\\nЗначение: лук\\nПримеры: 弓, 引, 张",
        "№58  彐\\nPinyin: jì\\nЗначение: свиная голова\\nПримеры: 归, 当, 录",
        "№59  彡\\nPinyin: shān\\nЗначение: волосы; узор\\nПримеры: 形, 彩, 影",
        "№60  彳\\nPinyin: chì\\nЗначение: шаг\\nПримеры: 行, 很, 往",
        "№61  心\\nPinyin: xīn\\nЗначение: сердце\\nПримеры: 心, 忙, 想",
        "№62  戈\\nPinyin: gē\\nЗначение: копьё\\nПримеры: 戈, 我, 战",
        "№63  戶\\nPinyin: hù\\nЗначение: дверь\\nПримеры: 户, 房, 所",
        "№64  手\\nPinyin: shǒu\\nЗначение: рука\\nПримеры: 手, 打, 拿",
        "№65  支\\nPinyin: zhī\\nЗначение: ветвь; поддержка\\nПримеры: 支, 枝, 翅",
        "№66  攴\\nPinyin: pū\\nЗначение: удар\\nПримеры: 收, 改, 政",
        "№67  文\\nPinyin: wén\\nЗначение: письменность\\nПримеры: 文, 这, 斑",
        "№68  斗\\nPinyin: dǒu\\nЗначение: ковш\\nПримеры: 斗, 料, 斜",
        "№69  斤\\nPinyin: jīn\\nЗначение: топор; цзинь\\nПримеры: 斤, 近, 新",
        "№70  方\\nPinyin: fāng\\nЗначение: сторона; направление\\nПримеры: 方, 放, 旅",
        "№71  无\\nPinyin: wú\\nЗначение: нет\\nПримеры: 无, 既, 旡",
        "№72  日\\nPinyin: rì\\nЗначение: солнце; день\\nПримеры: 日, 明, 时",
        "№73  曰\\nPinyin: yuē\\nЗначение: говорить\\nПримеры: 曰, 曹, 曼",
        "№74  月\\nPinyin: yuè\\nЗначение: луна; месяц\\nПримеры: 月, 朋, 服",
        "№75  木\\nPinyin: mù\\nЗначение: дерево\\nПримеры: 木, 林, 本",
        "№76  欠\\nPinyin: qiàn\\nЗначение: недоставать\\nПримеры: 欠, 欢, 次",
        "№77  止\\nPinyin: zhǐ\\nЗначение: останавливаться\\nПримеры: 止, 正, 此",
        "№78  歹\\nPinyin: dǎi\\nЗначение: смерть; плохой\\nПримеры: 歹, 死, 残",
        "№79  殳\\nPinyin: shū\\nЗначение: оружие; удар\\nПримеры: 段, 殿, 殺",
        "№80  毋\\nPinyin: wú\\nЗначение: не; запрещать\\nПримеры: 毋, 母, 每",
        "№81  比\\nPinyin: bǐ\\nЗначение: сравнивать\\nПримеры: 比, 毕, 毙",
        "№82  毛\\nPinyin: máo\\nЗначение: шерсть\\nПримеры: 毛, 毫, 毯",
        "№83  氏\\nPinyin: shì\\nЗначение: род; клан\\nПримеры: 氏, 民, 纸",
        "№84  气\\nPinyin: qì\\nЗначение: воздух; энергия\\nПримеры: 气, 汽, 氧",
        "№85  水\\nPinyin: shuǐ\\nЗначение: вода\\nПримеры: 水, 河, 海",
        "№86  火\\nPinyin: huǒ\\nЗначение: огонь\\nПримеры: 火, 灯, 热",
        "№87  爪\\nPinyin: zhǎo\\nЗначение: коготь\\nПримеры: 爪, 爱, 受",
        "№88  父\\nPinyin: fù\\nЗначение: отец\\nПримеры: 父, 爸, 爷",
        "№89  爻\\nPinyin: yáo\\nЗначение: черта гексаграммы\\nПримеры: 爻, 爽, 爾",
        "№90  爿\\nPinyin: pán\\nЗначение: расщеплённое дерево\\nПримеры: 状, 壮, 将",
        "№91  片\\nPinyin: piàn\\nЗначение: лист; пластина\\nПримеры: 片, 版, 牌",
        "№92  牙\\nPinyin: yá\\nЗначение: зуб\\nПримеры: 牙, 芽, 鸦",
        "№93  牛\\nPinyin: niú\\nЗначение: корова\\nПримеры: 牛, 物, 特",
        "№94  犬\\nPinyin: quǎn\\nЗначение: собака\\nПримеры: 犬, 狗, 猫",
        "№95  玄\\nPinyin: xuán\\nЗначение: тёмный; таинственный\\nПримеры: 玄, 率, 畜",
        "№96  玉\\nPinyin: yù\\nЗначение: нефрит\\nПримеры: 玉, 王, 珠",
        "№97  瓜\\nPinyin: guā\\nЗначение: дыня\\nПримеры: 瓜, 瓜, 瓣",
        "№98  瓦\\nPinyin: wǎ\\nЗначение: черепица\\nПримеры: 瓦, 瓶, 瓷",
        "№99  甘\\nPinyin: gān\\nЗначение: сладкий\\nПримеры: 甘, 甜, 某",
        "№100  生\\nPinyin: shēng\\nЗначение: жизнь; рождаться\\nПримеры: 生, 星, 牲",
        "№101  用\\nPinyin: yòng\\nЗначение: использовать\\nПримеры: 用, 甩, 甫",
        "№102  田\\nPinyin: tián\\nЗначение: поле\\nПримеры: 田, 男, 界",
        "№103  疋\\nPinyin: pǐ\\nЗначение: рулон ткани\\nПримеры: 疋, 疏, 疑",
        "№104  疒\\nPinyin: nè\\nЗначение: болезнь\\nПримеры: 病, 痛, 疼",
        "№105  癶\\nPinyin: bō\\nЗначение: расходящиеся ноги\\nПримеры: 癸, 登, 發",
        "№106  白\\nPinyin: bái\\nЗначение: белый\\nПримеры: 白, 百, 的",
        "№107  皮\\nPinyin: pí\\nЗначение: кожа\\nПримеры: 皮, 破, 皱",
        "№108  皿\\nPinyin: mǐn\\nЗначение: сосуд\\nПримеры: 皿, 盆, 盘",
        "№109  目\\nPinyin: mù\\nЗначение: глаз\\nПримеры: 目, 看, 睡",
        "№110  矛\\nPinyin: máo\\nЗначение: копьё\\nПримеры: 矛, 矜, 矞",
        "№111  矢\\nPinyin: shǐ\\nЗначение: стрела\\nПримеры: 矢, 知, 短",
        "№112  石\\nPinyin: shí\\nЗначение: камень\\nПримеры: 石, 破, 硬",
        "№113  示\\nPinyin: shì\\nЗначение: показывать; духи\\nПримеры: 示, 祝, 神",
        "№114  禸\\nPinyin: róu\\nЗначение: след зверя\\nПримеры: 禹, 禺, 离",
        "№115  禾\\nPinyin: hé\\nЗначение: зерно\\nПримеры: 禾, 秋, 种",
        "№116  穴\\nPinyin: xué\\nЗначение: пещера\\nПримеры: 穴, 空, 穿",
        "№117  立\\nPinyin: lì\\nЗначение: стоять\\nПримеры: 立, 站, 童",
        "№118  竹\\nPinyin: zhú\\nЗначение: бамбук\\nПримеры: 竹, 笑, 笔",
        "№119  米\\nPinyin: mǐ\\nЗначение: рис\\nПримеры: 米, 粉, 糖",
        "№120  糸\\nPinyin: mì\\nЗначение: шёлк\\nПримеры: 糸, 线, 纸",
        "№121  缶\\nPinyin: fǒu\\nЗначение: глиняный сосуд\\nПримеры: 缶, 缺, 罐",
        "№122  网\\nPinyin: wǎng\\nЗначение: сеть\\nПримеры: 网, 罗, 罪",
        "№123  羊\\nPinyin: yáng\\nЗначение: овца\\nПримеры: 羊, 美, 群",
        "№124  羽\\nPinyin: yǔ\\nЗначение: перо\\nПримеры: 羽, 習, 翼",
        "№125  老\\nPinyin: lǎo\\nЗначение: старый\\nПримеры: 老, 考, 者",
        "№126  而\\nPinyin: ér\\nЗначение: и; но\\nПримеры: 而, 耐, 耍",
        "№127  耒\\nPinyin: lěi\\nЗначение: плуг\\nПримеры: 耒, 耕, 耗",
        "№128  耳\\nPinyin: ěr\\nЗначение: ухо\\nПримеры: 耳, 聊, 聪",
        "№129  聿\\nPinyin: yù\\nЗначение: кисть\\nПримеры: 聿, 書, 肆",
        "№130  肉\\nPinyin: ròu\\nЗначение: мясо\\nПримеры: 肉, 肌, 胖",
        "№131  臣\\nPinyin: chén\\nЗначение: слуга\\nПримеры: 臣, 臨, 臣",
        "№132  自\\nPinyin: zì\\nЗначение: сам\\nПримеры: 自, 息, 鼻",
        "№133  至\\nPinyin: zhì\\nЗначение: достигать\\nПримеры: 至, 到, 致",
        "№134  臼\\nPinyin: jiù\\nЗначение: ступа\\nПримеры: 臼, 舅, 興",
        "№135  舌\\nPinyin: shé\\nЗначение: язык\\nПримеры: 舌, 舒, 甜",
        "№136  舛\\nPinyin: chuǎn\\nЗначение: ошибка; противоположность\\nПримеры: 舛, 舞, 舜",
        "№137  舟\\nPinyin: zhōu\\nЗначение: лодка\\nПримеры: 舟, 船, 航",
        "№138  艮\\nPinyin: gèn\\nЗначение: остановка; гора\\nПримеры: 艮, 良, 很",
        "№139  色\\nPinyin: sè\\nЗначение: цвет\\nПримеры: 色, 艳, 艴",
        "№140  艸\\nPinyin: cǎo\\nЗначение: трава\\nПримеры: 草, 花, 茶",
        "№141  虍\\nPinyin: hū\\nЗначение: тигр\\nПримеры: 虎, 虑, 虚",
        "№142  虫\\nPinyin: chóng\\nЗначение: насекомое\\nПримеры: 虫, 蚂, 蛇",
        "№143  血\\nPinyin: xuè\\nЗначение: кровь\\nПримеры: 血, 衅, 血",
        "№144  行\\nPinyin: xíng\\nЗначение: идти; ряд\\nПримеры: 行, 街, 術",
        "№145  衣\\nPinyin: yī\\nЗначение: одежда\\nПримеры: 衣, 衣, 装",
        "№146  襾\\nPinyin: yà\\nЗначение: покрывать\\nПримеры: 西, 要, 覆",
        "№147  見\\nPinyin: jiàn\\nЗначение: видеть\\nПримеры: 見, 观, 视",
        "№148  角\\nPinyin: jiǎo\\nЗначение: рог; угол\\nПримеры: 角, 解, 触",
        "№149  言\\nPinyin: yán\\nЗначение: речь\\nПримеры: 言, 语, 说",
        "№150  谷\\nPinyin: gǔ\\nЗначение: долина\\nПримеры: 谷, 欲, 谷",
        "№151  豆\\nPinyin: dòu\\nЗначение: боб\\nПримеры: 豆, 短, 豆",
        "№152  豕\\nPinyin: shǐ\\nЗначение: свинья\\nПримеры: 豕, 家, 象",
        "№153  豸\\nPinyin: zhì\\nЗначение: зверь\\nПримеры: 豸, 貌, 豹",
        "№154  貝\\nPinyin: bèi\\nЗначение: ракушка; деньги\\nПримеры: 貝, 财, 败",
        "№155  赤\\nPinyin: chì\\nЗначение: красный\\nПримеры: 赤, 赫, 赦",
        "№156  走\\nPinyin: zǒu\\nЗначение: идти; бежать\\nПримеры: 走, 起, 越",
        "№157  足\\nPinyin: zú\\nЗначение: нога\\nПримеры: 足, 跑, 路",
        "№158  身\\nPinyin: shēn\\nЗначение: тело\\nПримеры: 身, 躲, 躺",
        "№159  車\\nPinyin: chē\\nЗначение: повозка; машина\\nПримеры: 車, 车, 转",
        "№160  辛\\nPinyin: xīn\\nЗначение: горький\\nПримеры: 辛, 辣, 辨",
        "№161  辰\\nPinyin: chén\\nЗначение: утро; дракон\\nПримеры: 辰, 晨, 辱",
        "№162  辵\\nPinyin: chuò\\nЗначение: движение\\nПримеры: 近, 进, 远",
        "№163  邑\\nPinyin: yì\\nЗначение: город\\nПримеры: 都, 部, 那",
        "№164  酉\\nPinyin: yǒu\\nЗначение: вино; сосуд\\nПримеры: 酒, 配, 酸",
        "№165  釆\\nPinyin: biàn\\nЗначение: различать\\nПримеры: 釆, 采, 番",
        "№166  里\\nPinyin: lǐ\\nЗначение: деревня; ли\\nПримеры: 里, 重, 野",
        "№167  金\\nPinyin: jīn\\nЗначение: металл; золото\\nПримеры: 金, 钱, 银",
        "№168  長\\nPinyin: cháng\\nЗначение: длинный\\nПримеры: 長, 长, 张",
        "№169  門\\nPinyin: mén\\nЗначение: ворота\\nПримеры: 門, 问, 间",
        "№170  阜\\nPinyin: fù\\nЗначение: холм\\nПримеры: 阜, 院, 队",
        "№171  隶\\nPinyin: lì\\nЗначение: подчиняться\\nПримеры: 隶, 隶, 隷",
        "№172  隹\\nPinyin: zhuī\\nЗначение: короткохвостая птица\\nПримеры: 隹, 难, 集",
        "№173  雨\\nPinyin: yǔ\\nЗначение: дождь\\nПримеры: 雨, 雪, 雷",
        "№174  靑\\nPinyin: qīng\\nЗначение: синий/зелёный\\nПримеры: 青, 静, 清",
        "№175  非\\nPinyin: fēi\\nЗначение: не\\nПримеры: 非, 靠, 靡",
        "№176  面\\nPinyin: miàn\\nЗначение: лицо; поверхность\\nПримеры: 面, 靦, 靧",
        "№177  革\\nPinyin: gé\\nЗначение: кожа\\nПримеры: 革, 鞋, 鞭",
        "№178  韋\\nPinyin: wéi\\nЗначение: выделанная кожа\\nПримеры: 韦, 韩, 韬",
        "№179  韭\\nPinyin: jiǔ\\nЗначение: лук-джусай\\nПримеры: 韭, 韱, 韲",
        "№180  音\\nPinyin: yīn\\nЗначение: звук\\nПримеры: 音, 音, 韵",
        "№181  頁\\nPinyin: yè\\nЗначение: голова; страница\\nПримеры: 页, 顶, 领",
        "№182  風\\nPinyin: fēng\\nЗначение: ветер\\nПримеры: 风, 飘, 飓",
        "№183  飛\\nPinyin: fēi\\nЗначение: летать\\nПримеры: 飞, 飛, 飜",
        "№184  食\\nPinyin: shí\\nЗначение: еда\\nПримеры: 食, 饭, 饿",
        "№185  首\\nPinyin: shǒu\\nЗначение: голова\\nПримеры: 首, 道, 馘",
        "№186  香\\nPinyin: xiāng\\nЗначение: аромат\\nПримеры: 香, 馨, 馥",
        "№187  馬\\nPinyin: mǎ\\nЗначение: лошадь\\nПримеры: 马, 骑, 验",
        "№188  骨\\nPinyin: gǔ\\nЗначение: кость\\nПримеры: 骨, 验, 體",
        "№189  高\\nPinyin: gāo\\nЗначение: высокий\\nПримеры: 高, 高, 髙",
        "№190  髟\\nPinyin: biāo\\nЗначение: длинные волосы\\nПримеры: 髟, 髮, 鬓",
        "№191  鬥\\nPinyin: dòu\\nЗначение: борьба\\nПримеры: 鬥, 鬧, 鬭",
        "№192  鬯\\nPinyin: chàng\\nЗначение: ритуальное вино\\nПримеры: 鬯, 鬱, 鬯",
        "№193  鬲\\nPinyin: lì\\nЗначение: котёл\\nПримеры: 鬲, 融, 鬻",
        "№194  鬼\\nPinyin: guǐ\\nЗначение: дух\\nПримеры: 鬼, 魂, 魔",
        "№195  魚\\nPinyin: yú\\nЗначение: рыба\\nПримеры: 鱼, 鲜, 鳞",
        "№196  鳥\\nPinyin: niǎo\\nЗначение: птица\\nПримеры: 鸟, 鸡, 鸭",
        "№197  鹵\\nPinyin: lǔ\\nЗначение: соль\\nПримеры: 卤, 鹹, 鹽",
        "№198  鹿\\nPinyin: lù\\nЗначение: олень\\nПримеры: 鹿, 麟, 麓",
        "№199  麥\\nPinyin: mài\\nЗначение: пшеница\\nПримеры: 麦, 麵, 麩",
        "№200  麻\\nPinyin: má\\nЗначение: конопля\\nПримеры: 麻, 麼, 魔",
        "№201  黃\\nPinyin: huáng\\nЗначение: жёлтый\\nПримеры: 黄, 黃, 黉",
        "№202  黍\\nPinyin: shǔ\\nЗначение: просо\\nПримеры: 黍, 黏, 黎",
        "№203  黑\\nPinyin: hēi\\nЗначение: чёрный\\nПримеры: 黑, 默, 点",
        "№204  黹\\nPinyin: zhǐ\\nЗначение: вышивка\\nПримеры: 黹, 黻, 黼",
        "№205  黽\\nPinyin: mǐn\\nЗначение: лягушка\\nПримеры: 黾, 鼋, 鼍",
        "№206  鼎\\nPinyin: dǐng\\nЗначение: треножник\\nПримеры: 鼎, 鼏, 鼎",
        "№207  鼓\\nPinyin: gǔ\\nЗначение: барабан\\nПримеры: 鼓, 鼓, 鼙",
        "№208  鼠\\nPinyin: shǔ\\nЗначение: мышь\\nПримеры: 鼠, 鼠, 鼬",
        "№209  鼻\\nPinyin: bí\\nЗначение: нос\\nПримеры: 鼻, 鼻, 鼾",
        "№210  齊\\nPinyin: qí\\nЗначение: ровный; вместе\\nПримеры: 齐, 齐, 齋",
        "№211  齒\\nPinyin: chǐ\\nЗначение: зубы\\nПримеры: 齿, 龄, 龋",
        "№212  龍\\nPinyin: lóng\\nЗначение: дракон\\nПримеры: 龙, 龍, 龚",
        "№213  龜\\nPinyin: guī\\nЗначение: черепаха\\nПримеры: 龟, 龜, 龟",
        "№214  龠\\nPinyin: yuè\\nЗначение: флейта\\nПримеры: 龠, 龢, 龥"
    };

    static final String[] CHARS = {
        "你\\nPinyin: nǐ\\nЗначение: ты\\nПодсказка: человек 亻 + звук 尔",
        "好\\nPinyin: hǎo\\nЗначение: хорошо\\nПодсказка: женщина 女 + ребёнок 子",
        "我\\nPinyin: wǒ\\nЗначение: я\\nПодсказка: частый базовый иероглиф",
        "是\\nPinyin: shì\\nЗначение: быть; являться\\nПодсказка: самый частый глагол-связка",
        "不\\nPinyin: bù\\nЗначение: не\\nПодсказка: отрицание",
        "中\\nPinyin: zhōng\\nЗначение: середина; Китай\\nПодсказка: ключ 丨 помогает видеть вертикаль",
        "国\\nPinyin: guó\\nЗначение: страна\\nПодсказка: ограда 囗 + нефрит 玉",
        "人\\nPinyin: rén\\nЗначение: человек\\nПодсказка: один из главных ключей",
        "口\\nPinyin: kǒu\\nЗначение: рот\\nПодсказка: часто связан с речью/едой",
        "日\\nPinyin: rì\\nЗначение: солнце; день\\nПодсказка: часто про время",
        "月\\nPinyin: yuè\\nЗначение: луна; месяц\\nПодсказка: часто про время или тело",
        "水\\nPinyin: shuǐ\\nЗначение: вода\\nПодсказка: упрощённо часто 氵",
        "火\\nPinyin: huǒ\\nЗначение: огонь\\nПодсказка: часто 灬 внизу",
        "山\\nPinyin: shān\\nЗначение: гора\\nПодсказка: простой пиктограф",
        "木\\nPinyin: mù\\nЗначение: дерево\\nПодсказка: два 木 = 林",
        "大\\nPinyin: dà\\nЗначение: большой\\nПодсказка: человек с раскинутыми руками",
        "小\\nPinyin: xiǎo\\nЗначение: маленький\\nПодсказка: противоположность 大",
        "天\\nPinyin: tiān\\nЗначение: небо; день\\nПодсказка: 大 + верхняя черта",
        "学\\nPinyin: xué\\nЗначение: учиться\\nПодсказка: важный базовый иероглиф",
        "汉\\nPinyin: hàn\\nЗначение: китайский; хань\\nПодсказка: 氵 вода + 又"
    };

    static final String[] PINYIN = {
        "a\\nЗвучание: а\\nКомментарий: открытый звук",
        "ai\\nЗвучание: ай\\nКомментарий: как в слове “ай”",
        "an\\nЗвучание: ань\\nКомментарий: носовой финаль",
        "ang\\nЗвучание: анъ\\nКомментарий: задний носовой финаль",
        "e\\nЗвучание: э\\nКомментарий: глубокий звук",
        "ei\\nЗвучание: эй\\nКомментарий: как “эй”",
        "en\\nЗвучание: энь\\nКомментарий: передний носовой финаль",
        "eng\\nЗвучание: энъ\\nКомментарий: задний носовой финаль",
        "i\\nЗвучание: и\\nКомментарий: после некоторых согласных звучит иначе",
        "o\\nЗвучание: о\\nКомментарий: округлённый звук",
        "ou\\nЗвучание: оу\\nКомментарий: как “оу”",
        "u\\nЗвучание: у\\nКомментарий: обычный звук у",
        "ü\\nЗвучание: юй\\nКомментарий: губы как у, язык как и",
        "ba\\nЗвучание: bā\\nКомментарий: пример слога с b",
        "ma\\nЗвучание: mā/má/mǎ/mà\\nКомментарий: слог для тренировки тонов",
        "shi\\nЗвучание: shì\\nКомментарий: важный слог",
        "zhong\\nЗвучание: zhōng\\nКомментарий: как в 中国",
        "xue\\nЗвучание: xué\\nКомментарий: как в 学",
        "han\\nЗвучание: hàn\\nКомментарий: как в 汉语",
        "zi\\nЗвучание: zì\\nКомментарий: как в 汉字"
    };

    static final String[] TONES = {
        "1 тон\\nПример: mā\\nКак произносить: ровный высокий: держим звук ровно",
        "2 тон\\nПример: má\\nКак произносить: восходящий: как вопрос “а?”",
        "3 тон\\nПример: mǎ\\nКак произносить: низкий с подъёмом: сначала вниз, потом вверх",
        "4 тон\\nПример: mà\\nКак произносить: резкий нисходящий: коротко и уверенно",
        "нейтральный\\nПример: ma\\nКак произносить: лёгкий и короткий без ударения"
    };

    static final String[] LESSON_NAMES = {"214 ключей", "Базовые иероглифы", "Пиньинь", "Тоны"};
    static final String[] LESSON_MODES = {"radicals", "chars", "pinyin", "tones"};

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        prefs = getSharedPreferences("learning_progress_v3", MODE_PRIVATE);
        showHome();
    }

    TextView text(String value, int sp, boolean bold) {
        TextView v = new TextView(this);
        v.setText(value);
        v.setTextSize(sp);
        v.setTextColor(INK);
        v.setPadding(18, 12, 18, 12);
        if (bold) v.setTypeface(Typeface.DEFAULT_BOLD);
        return v;
    }

    Button button(String value) {
        Button b = new Button(this);
        b.setText(value);
        b.setAllCaps(false);
        b.setTextSize(16);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
        lp.setMargins(0, 7, 0, 7);
        b.setLayoutParams(lp);
        return b;
    }

    TextView chip(String value) {
        TextView v = text(value, 15, true);
        v.setTextColor(Color.WHITE);
        v.setBackgroundColor(ACCENT);
        v.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
        lp.setMargins(0, 7, 0, 7);
        v.setLayoutParams(lp);
        return v;
    }

    void screen(String title, String sub) {
        ScrollView scroll = new ScrollView(this);
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(26, 30, 26, 36);
        root.setBackgroundColor(BG);
        scroll.addView(root);
        root.addView(text(title, 28, true));
        root.addView(text(sub, 16, false));
        setContentView(scroll);
    }

    String[] dataFor(String mode) {
        if ("chars".equals(mode)) return CHARS;
        if ("pinyin".equals(mode)) return PINYIN;
        if ("tones".equals(mode)) return TONES;
        return RADICALS;
    }

    String titleFor(String mode) {
        if ("chars".equals(mode)) return "Базовые иероглифы";
        if ("pinyin".equals(mode)) return "Пиньинь";
        if ("tones".equals(mode)) return "Китайские тоны";
        return "214 ключей Канси";
    }

    void showHome() {
        screen("Китайский Мастер 汉字", "Маршрут: 214 ключей → базовые иероглифы → пиньинь → тоны → ежедневное повторение");
        root.addView(chip("Сегодня к повторению: " + dueCount() + " карточек  •  Серия: " + prefs.getInt("streak", 0) + " дней"));
        root.addView(text(progressText(), 16, true));

        Button learn = button("Продолжить обучение");
        Button review = button("Повторение SRS");
        Button test = button("Мини-тест");
        Button search = button("Поиск по ключам");
        Button path = button("Учебный маршрут");
        Button reset = button("Сбросить прогресс");
        root.addView(learn); root.addView(review); root.addView(test); root.addView(search); root.addView(path); root.addView(reset);

        learn.setOnClickListener(v -> showNextLesson());
        review.setOnClickListener(v -> showReview());
        test.setOnClickListener(v -> showQuiz());
        search.setOnClickListener(v -> showSearch());
        path.setOnClickListener(v -> showPath());
        reset.setOnClickListener(v -> { prefs.edit().clear().apply(); Toast.makeText(this, "Прогресс сброшен", Toast.LENGTH_SHORT).show(); showHome(); });
    }

    void showPath() {
        screen("Учебный маршрут", "Идём от формы и смысла к чтению и произношению");
        for (int i=0; i<LESSON_MODES.length; i++) {
            String m = LESSON_MODES[i];
            Button b = button((i+1) + ". " + LESSON_NAMES[i] + " — " + knownCount(m) + "/" + dataFor(m).length);
            final String mode = m;
            b.setOnClickListener(v -> showCards(mode, nextIndex(mode)));
            root.addView(b);
        }
        root.addView(text("Идея: сначала видеть строительные блоки иероглифов, затем сами базовые иероглифы, потом закреплять чтение через пиньинь и тоны.", 16, false));
        Button home = button("На главную"); root.addView(home); home.setOnClickListener(v -> showHome());
    }

    void showNextLesson() {
        for (String m : LESSON_MODES) if (knownCount(m) < dataFor(m).length) { showCards(m, nextIndex(m)); return; }
        showReview();
    }

    int nextIndex(String mode) {
        String[] d = dataFor(mode);
        for (int i=0;i<d.length;i++) if (!prefs.getBoolean(key(mode,i,"known"), false)) return i;
        return 0;
    }

    void showCards(String mode, int idx) {
        currentMode = mode;
        String[] d = dataFor(mode);
        currentIndex = Math.max(0, Math.min(idx, d.length - 1));
        screen(titleFor(mode), "Карточка " + (currentIndex + 1) + " / " + d.length + "  •  изучено " + knownCount(mode));

        TextView card = text(d[currentIndex], mode.equals("radicals") || mode.equals("chars") ? 26 : 22, true);
        card.setGravity(Gravity.CENTER);
        card.setBackgroundColor(CARD);
        root.addView(card);
        root.addView(text(tipFor(mode, d[currentIndex]), 15, false));

        Button hard = button("Трудно — повторить скоро");
        Button good = button("Знаю нормально ✓");
        Button easy = button("Легко — увеличить интервал ⭐");
        Button prev = button("← Предыдущая");
        Button next = button("Следующая →");
        Button home = button("На главную");
        root.addView(hard); root.addView(good); root.addView(easy); root.addView(prev); root.addView(next); root.addView(home);
        hard.setOnClickListener(v -> { rate(mode, currentIndex, 0); showCards(mode, currentIndex + 1); });
        good.setOnClickListener(v -> { rate(mode, currentIndex, 1); showCards(mode, currentIndex + 1); });
        easy.setOnClickListener(v -> { rate(mode, currentIndex, 2); showCards(mode, currentIndex + 1); });
        prev.setOnClickListener(v -> showCards(mode, currentIndex - 1));
        next.setOnClickListener(v -> showCards(mode, currentIndex + 1));
        home.setOnClickListener(v -> showHome());
    }

    String tipFor(String mode, String item) {
        if ("radicals".equals(mode)) return "Совет: найди этот ключ в примерах и запомни его образ. Ключ часто намекает на смысл иероглифа.";
        if ("chars".equals(mode)) return "Совет: произнеси вслух, посмотри на компоненты и придумай короткую ассоциацию.";
        if ("pinyin".equals(mode)) return "Совет: сначала читай медленно, потом добавляй тон. Пиньинь — мост от звука к иероглифу.";
        return "Совет: произнеси один и тот же слог всеми тонами: mā, má, mǎ, mà, ma.";
    }

    String key(String mode, int i, String field) { return mode + "_" + i + "_" + field; }
    long nowDay() { return System.currentTimeMillis() / 86400000L; }

    void rate(String mode, int i, int quality) {
        int interval = prefs.getInt(key(mode,i,"interval"), 0);
        if (quality == 0) interval = 1;
        else if (quality == 1) interval = interval <= 0 ? 2 : Math.min(60, interval * 2);
        else interval = interval <= 0 ? 4 : Math.min(120, interval * 3);
        prefs.edit()
                .putBoolean(key(mode,i,"known"), true)
                .putInt(key(mode,i,"interval"), interval)
                .putLong(key(mode,i,"due"), nowDay() + interval)
                .apply();
        Toast.makeText(this, "Следующее повторение через " + interval + " дн.", Toast.LENGTH_SHORT).show();
    }

    int knownCount(String mode) { int c=0; for(int i=0;i<dataFor(mode).length;i++) if(prefs.getBoolean(key(mode,i,"known"),false)) c++; return c; }

    int dueCount() {
        int c = 0; long n = nowDay();
        for (String m: LESSON_MODES) for(int i=0;i<dataFor(m).length;i++) {
            if (prefs.getBoolean(key(m,i,"known"), false) && prefs.getLong(key(m,i,"due"), n+99) <= n) c++;
        }
        return c;
    }

    String progressText() {
        return "Ключи: " + knownCount("radicals") + "/" + RADICALS.length +
                "
Иероглифы: " + knownCount("chars") + "/" + CHARS.length +
                "
Пиньинь: " + knownCount("pinyin") + "/" + PINYIN.length +
                "
Тоны: " + knownCount("tones") + "/" + TONES.length;
    }

    void showReview() {
        long n = nowDay();
        for (String m: LESSON_MODES) for(int i=0;i<dataFor(m).length;i++) {
            if (prefs.getBoolean(key(m,i,"known"), false) && prefs.getLong(key(m,i,"due"), n) <= n) { showCards(m, i); return; }
        }
        screen("Повторение SRS", "На сегодня всё чисто 🎉");
        root.addView(text("Нет просроченных карточек. Можно продолжить обучение или пройти мини-тест.", 18, true));
        Button next = button("Продолжить обучение"); Button quiz = button("Мини-тест"); Button home = button("На главную");
        root.addView(next); root.addView(quiz); root.addView(home);
        next.setOnClickListener(v -> showNextLesson()); quiz.setOnClickListener(v -> showQuiz()); home.setOnClickListener(v -> showHome());
    }

    void showSearch() {
        screen("Поиск по ключам", "Ищи по символу, номеру, pinyin, русскому значению или примеру");
        EditText input = new EditText(this); input.setHint("например: вода, shuǐ, 水, сердце"); root.addView(input);
        Button run = button("Найти"); root.addView(run);
        LinearLayout results = new LinearLayout(this); results.setOrientation(LinearLayout.VERTICAL); root.addView(results);
        Button home = button("На главную"); root.addView(home);
        run.setOnClickListener(v -> {
            results.removeAllViews();
            String q = input.getText().toString().toLowerCase(Locale.ROOT).trim();
            if (q.length()==0) { results.addView(text("Введите запрос", 16, false)); return; }
            for (int i=0;i<RADICALS.length;i++) {
                if (RADICALS[i].toLowerCase(Locale.ROOT).contains(q)) {
                    final int idx=i;
                    Button item = button(RADICALS[i].split("\\n")[0]);
                    item.setOnClickListener(x -> showCards("radicals", idx));
                    results.addView(item);
                }
            }
            if (results.getChildCount()==0) results.addView(text("Ничего не найдено", 16, false));
        });
        home.setOnClickListener(v -> showHome());
    }

    String firstLine(String s) { return s.split("\\n")[0]; }
    String meaningOf(String s) { try { return s.split("Значение: ")[1].split("\\n")[0]; } catch(Exception e) { return firstLine(s); } }

    void showQuiz() {
        screen("Мини-тест", "Тренируем ключи, иероглифы, пиньинь и тоны короткими вопросами");
        int type = random.nextInt(3);
        if (type == 0) quizRadicalMeaning();
        else if (type == 1) quizCharacter();
        else quizTone();
        Button home = button("На главную"); root.addView(home); home.setOnClickListener(v -> showHome());
    }

    void quizRadicalMeaning() {
        int correct = random.nextInt(RADICALS.length);
        String ask = meaningOf(RADICALS[correct]);
        root.addView(text("Какой ключ означает: “" + ask + "”?", 22, true));
        ArrayList<Integer> opts = randomOptions(RADICALS.length, correct);
        for (int idx: opts) addAnswerButton(firstLine(RADICALS[idx]), idx == correct, "Правильно: " + firstLine(RADICALS[correct]), "radicals", correct);
    }

    void quizCharacter() {
        int correct = random.nextInt(CHARS.length);
        String ask = meaningOf(CHARS[correct]);
        root.addView(text("Какой иероглиф означает: “" + ask + "”?", 22, true));
        ArrayList<Integer> opts = randomOptions(CHARS.length, correct);
        for (int idx: opts) addAnswerButton(firstLine(CHARS[idx]), idx == correct, "Правильно: " + firstLine(CHARS[correct]), "chars", correct);
    }

    void quizTone() {
        String[] examples = {"mā — 1 тон: ровный", "má — 2 тон: вверх", "mǎ — 3 тон: вниз-вверх", "mà — 4 тон: резко вниз"};
        int correct = random.nextInt(examples.length);
        root.addView(text("Выбери описание для: " + examples[correct].split(" — ")[0], 22, true));
        ArrayList<Integer> opts = randomOptions(examples.length, correct);
        for (int idx: opts) addAnswerButton(examples[idx].split(" — ")[1], idx == correct, "Правильно: " + examples[correct], "tones", Math.min(correct, TONES.length-1));
    }

    ArrayList<Integer> randomOptions(int max, int correct) {
        ArrayList<Integer> opts = new ArrayList<>(); opts.add(correct);
        while(opts.size() < Math.min(4, max)) { int x=random.nextInt(max); if(!opts.contains(x)) opts.add(x); }
        Collections.shuffle(opts); return opts;
    }

    void addAnswerButton(String label, boolean ok, String msg, String mode, int idx) {
        Button b = button(label);
        b.setOnClickListener(v -> {
            Toast.makeText(this, ok ? "Верно!" : msg, Toast.LENGTH_LONG).show();
            if (ok) rate(mode, idx, 1);
            showQuiz();
        });
        root.addView(b);
    }
}
