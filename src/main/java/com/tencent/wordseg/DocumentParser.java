package com.tencent.wordseg;

import com.google.common.collect.Lists;
import org.apache.hadoop.io.Text;
import org.apache.tools.ant.filters.StringInputStream;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * This class responsible for extract main body from json-style data.
 * e.g
 * "astro.fashion.qq.com/a/20131015/002566.htm	{"response":{"code":0,"msg":"Sucess","dext":""},"data":{"url":"http:\/\/astro.fashion.qq.com\/a\/20131015\/002566.htm","source":{"source_id":"99","source_name":"自定义来源","source_ename":"10zidingyilaiyuan","source_desc":"&nbsp;","source_catalog":"","source_sequence":"999","source_url":"&nbsp;","source_status":"1","source_img":"","source_signname":"","source_signflag":"1","FSignName":"","source_desc_replace":"星座论坛"},"Fshortening":"kuaixun;newest;ctxy","relatelink":[{"related_url":"http:\/\/astro.fashion.qq.com\/a\/20130919\/003487.htm","related_title":null,"related_time":"2013.09.19"},{"related_url":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/135\/226\/1337\/86996190_small.jpg\" icontype=\"0\">金钱会夺走你的爱吗<\/a> <span>2013.09.19<\/span><br>          &#183;<a href=\"http:\/\/astro.lady.qq.com\/a\/20130214\/000026.htm","related_title":null,"related_time":"2013.02.14"},{"related_url":"http:\/\/astro.lady.qq.com\/a\/20130121\/000001.htm","related_title":null,"related_time":"2013.01.21"},{"related_url":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/1\/43\/1248\/81162166_small.jpg\" icontype=\"0\">12星座谁金钱运最旺<\/a> <span>2013.01.21<\/span><br>          &#183;<a href=\"http:\/\/astro.lady.qq.com\/a\/20121009\/000012.htm","related_title":null,"related_time":"2012.10.09"},{"related_url":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/16\/141\/1163\/75660046_small.jpg\" icontype=\"0\">12星谁易沦为金钱奴<\/a> <span>2012.10.09<\/span><br>          &#183;<a href=\"http:\/\/astro.lady.qq.com\/a\/20120927\/000008.htm","related_title":null,"related_time":"2012.09.27"}],"cltitle":"12星座的金钱爱情观","cstitle":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/175\/93\/1438\/93529840.jpg","pubtime":"2013-10-15 07:25:23","type":"0","keyword":"","level":"1","desc":"白羊座优秀的白羊座，一生除了要争取成功外，在生活上是不会做没有目地和回报的工作。他们在处理感情和金钱上，通常也相当理性，也许他会一时热情冲动，但这情形...","imgurl":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/155\/93\/1438\/93529820_small.jpg","imgurl2":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/155\/93\/1438\/93529820_small2.jpg","fimg":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/155\/93\/1438\/93529820.jpg","image":[{"img":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/155\/93\/1438\/93529820.jpg","desc":""},{"img":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/203\/93\/1438\/93529868.jpg","desc":""},{"img":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/242\/93\/1438\/93529907.jpg","desc":""},{"img":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/16\/94\/1438\/93529936.png","desc":""}],"fvideo":false,"video":false,"content":[{"type":"img","img":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/155\/93\/1438\/93529820.jpg"},{"type":"text","info":"白羊座"},{"type":"text","info":"优秀的白羊座，一生除了要争取成功外，在生活上是不会做没有目地和回报的工作。他们在处理感情和金钱上，通常也相当理性，也许他会一时热情冲动，但这情形绝不可能维持三天。他们当然都要疯狂热烈的爱情，但如果爱情代表著「未知”与“不定”时，那么白羊会选择具有可以掌握与控管的金钱在手上。对白羊座而言，只有这个座右铭最动心：“唯有成功的甜美，可以抚慰失败的情伤。”"},{"type":"text","info":"金牛座"},{"type":"text","info":"金牛座是出了名的理财专家，金钱对他们来说可是一种信仰，而处理金钱的态度和方法则是一种极致的艺术。金牛座对爱情有特别的品味和需要，爱情对金牛座而言，是一种对艺术品的鉴赏能力的结果，你瞧他们如何把玩或珍藏这项艺术品，就知他付出的心力。千万别忘了，金牛座虽然可以深情固执如牛，但没有任何人事物可以打败他的信仰！除非这段爱情被认定是世上绝版珍品，他就可以为了保有它，而放弃一切。"},{"type":"text","info":"双子座"},{"type":"text","info":"双子座一族，是标准幸运的“拆白党”；无论在工作事业人际或爱情，都有许多莫名其妙的好运道。别看他们变化快速、机智过人，但在生活习性上却是“以不变应万变”的大懒鬼，他们懒得花时间去分辨银行利率或品牌使用。基本上，他们的安全感建筑在一种“惯性”上，所以只要你可以提供他一个可以习惯性依赖的模式，让那成为他“生活必需品”的感觉。对他来说，金钱在眼下够用就好，他会先追赶刺激大脑的爱情。"},{"type":"img","img":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/203\/93\/1438\/93529868.jpg"},{"type":"text","info":"巨蟹座"},{"type":"text","info":"一向拥有浪漫情怀的巨蟹座，对爱情的点滴回忆可以钜细靡遗如数家珍，同时他们会为了心中伟大的爱情不惜“暂时”离家潜逃，但绝不会搞得众叛亲离。金钱，对巨蟹座而言是生活的基础保障，就像阳光、空气和水，不可或缺。但巨蟹不是那种每天看帐本锱铢必较型的人，他只看财务计画的大方向，确定一切都顺着合理的趋势方向走，他们同时是非常棒的买卖高手。所以巨蟹座一定会想办法让爱情与面包聚结，他们会为爱远走高飞，但也会准备点干粮和盘缠。"},{"type":"text","info":"狮子座"},{"type":"text","info":"狮子座一向是“金字招牌”的追求者，他们很重视人事物的血统、来源与正规出处。他们对成功的定义，第一个念头和印象辨识，是来自于外在所知金钱身份地位。可想而知，他们的人生标帜必须让他们感到荣耀感。在金钱财务上他们可不像外表那样豪气随性，他们会很冷静并且小心翼翼，在重要关键虽不手软，但在出手前一定要清楚每分每毫是用在哪些地方。狮子座绝不做一个冤大头！他们选择的准爱情也是以这样的标准进行。他们可以错过爱情，但绝不能错过面包！"},{"type":"text","info":"处女座"},{"type":"text","info":"我认为处女座在金钱方面的态度，可以用怪胎来形容。基本上，他们的一丝不苟有条不紊，在处理任何事情上都有一定的严谨规矩。在金钱的需要态度方面，处女座不会与金钱为敌，但也不会为钱搞死自己，他们只要确定工作和生活稳定，就会自在轻松，不会真的去计算手上银子有多少斤两。但对于爱情，他们却没那么容易轻松以对，有时到了神经紧张过度敏感。他们如果选择爱情，主因是他们认为这是一种道德和操守，他们害怕背负让“物质战胜情感”所产生的公评言论。"},{"type":"img","img":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/242\/93\/1438\/93529907.jpg"},{"type":"text","info":"天秤座"},{"type":"text","info":"天秤座很懂生活享受，金钱方面也比其他人容易获取，虽然很多人都认为天秤座会花钱，但他们一样很懂得如何省钱。就是因为他们在金钱方面，不容易感受到压力，所以金钱态度比较豁达，就算左手进右手出，他一样照自己生活步调过日子。天秤唯一不能拒千里之外的，就是深陷在爱情气氛里的感受，再精明的天秤座都难逃这种爱情美感，他们喜欢用爱情麻痹他们的脑。他们自有妙计，表面选择爱情，骨子里却跑向实际的面包。又天性使然，他们会继续在其中徘徊犹豫。"},{"type":"text","info":"天蝎座"},{"type":"text","info":"天蝎座的外表和内在，往往如南辕和北辙；天蝎座喜欢对外人谈理财，私下却没那么精明，在财务上无特别的警觉性，常常会因为心情的好恶起伏，让情绪决定如何挥霍无度。除非他们尝到真正的苦头，要不他们可是不见棺材不掉泪。他们在爱情方面，也很纵情任性，不知节制。当爱情遇上面包，他们连考虑都不考虑，先跟着爱情跑。也许是天性使然，他们总认为面粉就在厨房里，任何时候都可以发面做面包，反正船到桥头自然直，就算火烧船舱，自然有人来救火。"},{"type":"text","info":"射手座"},{"type":"text","info":"我身边的射手座，金钱运上常常出现游走于贫富之间，起落很大的生活状况。大家看到的射手座都很会散财，但是他们可不会随随便便把财散到别人身上去，他们大部份都会运用在自己身上。许多射手座是Casino的常客，因为他们对金钱可大笔花，也认为该大赚一笔回来。在爱情有效期限上，不要太要求射手座给你太长的时间，他太热爱自由，虽然喜欢热恋的感觉，却从未想过要固定下来。如果他没有选择爱情，不纯然为了面包的理由，只能说他不爱被管束的感觉。"},{"type":"img","img":"http:\/\/img1.gtimg.com\/astro\/pics\/hv1\/16\/94\/1438\/93529936.png"},{"type":"text","info":"摩羯座"},{"type":"text","info":"奇怪吧！摩羯一向不是有趣的恋人，但却是一个坚贞不二可以托付终身的伴侣。别看他们外表严肃凡事讲求原则，但内心相当柔软，一旦陷入了爱河，更是热情如火一发不可收拾。他们对于金钱有一些实际的看法，不会随性浪费且洁身自爱，他们不会去计较金钱一时的多寡，自有内心的盘算。对于爱情，摩羯凡事都会以对方为中心，会无怨无悔的付出一切，可以吝啬并俭省自己来照顾对方。这样看来，你认为摩羯在选择面包和爱情时，他会靠向那一边呢？！"},{"type":"text","info":"水瓶座"},{"type":"text","info":"大部份的水瓶座，在金钱方面都不甚安定，这完全应了他们理想主义的天性，对于金钱的看待，从来不觉得有什么特别的人生价值可言。水瓶座最在乎的是精神上是否能够获得满足，可以为了追求心中理想，牺牲物质方面的考量。他们可以自得其乐自娱娱人，只要有值得信赖的心灵伴侣在一旁，他们就觉得生命无限美好。水瓶座为爱牺牲奉献的事，有时到了盲目不清的地步，他们对于爱情就像对自己追求的理想，抱着至高无尚的真诚，直到爱情完全破灭才会罢休。"},{"type":"text","info":"双鱼座"},{"type":"text","info":"你可曾看见过满口股市行情的双鱼座？他们太清楚自己的性格过于松散，又经不住别人的说东道西，所以才与复杂的财务和现实保持距离。当然这不表示双鱼座的人不需要钱或不爱财，只是一有机会他会把所有钱花在心爱的人身上。他们禁不住他人的说项，所以难以聚财；除非他不听不闻不问他人事情。双鱼的浪漫与善解人意有口皆碑，他们非常在意爱人的情绪，爱情对他们来说是天是地。如果一位双鱼座选择了面包，那是因为他要把它献给心爱的人。"}],"columnInfo":[{"Fshortening":"kuaixun","Ftitle":"星座快讯","Ftree":{"kuaixun":{"CatalogInfo":{"Fcatalog_id":"819","Fshortening":"kuaixun","Ftitle":"星座快讯","Fparent":"","Ftree":"kuaixun","Fstatus":"0","Fcatalog_sequence":"999","Fcomment_grpid":"0"},"ChildrenNodes":[]}}},{"Fshortening":"newest","Ftitle":"今日星事","Ftree":{"index":{"CatalogInfo":{"Fcatalog_id":"74","Fshortening":"index","Ftitle":"星座首页","Fparent":"","Ftree":"index","Fstatus":"0","Fcatalog_sequence":"999","Fcomment_grpid":"0"},"ChildrenNodes":{"newest":{"CatalogInfo":{"Fcatalog_id":"84","Fshortening":"newest","Ftitle":"今日星事","Fparent":"index","Ftree":"index-newest","Fstatus":"0","Fcatalog_sequence":"999","Fcomment_grpid":"0"},"ChildrenNodes":[]}}}}},{"Fshortening":"ctxy","Ftitle":"彩图星语","Ftree":{"pic":{"CatalogInfo":{"Fcatalog_id":"261","Fshortening":"pic","Ftitle":"图库","Fparent":"","Ftree":"pic","Fstatus":"0","Fcatalog_sequence":"999","Fcomment_grpid":"0"},"ChildrenNodes":{"ctxy":{"CatalogInfo":{"Fcatalog_id":"372","Fshortening":"ctxy","Ftitle":"彩图星语","Fparent":"pic","Ftree":"pic-ctxy","Fstatus":"0","Fcatalog_sequence":"999","Fcomment_grpid":"0"},"ChildrenNodes":[]}}}}}]}}"
 */
public class DocumentParser
{
    private ObjectMapper mapper = new ObjectMapper();

    List<String> extractMainBody(Text value) throws IOException
    {

        List<String> result = Lists.newArrayList();

        //remove prefix of URL,which is separated by "\t" from json string
        byte[] bytes = value.getBytes();
        int length = value.getLength();

        int index = 0;
        for (; index < length; index++)
        {
            if (bytes[index] == '\t')
            {
                break;
            }
        }

        //move forward one step to skip "\t"
        index++;

        //if there is no content
        if (index >= length)
        {
            return result;
        }

        ByteArrayInputStream is = new ByteArrayInputStream(bytes, index, length - index);
        JsonNode root = mapper.readTree(is);

        //TODO
        //do dome research to find a more efficient approach.
        JsonNode contentContainer = root.findValue("content");

        if (contentContainer != null)
        {
            Iterator<JsonNode> iterator = contentContainer.getElements();
            while (iterator.hasNext())
            {
                JsonNode contentNode = iterator.next();

                JsonNode typeNode = contentNode.get("type");
                if (typeNode.getTextValue().trim().equalsIgnoreCase("text"))
                {
                    JsonNode infoNode = contentNode.get("info");
                    result.add(infoNode.getTextValue());
                }
            }
        }
        return result;
    }


    public static void main(String[] args) throws IOException
    {

        String str = "[{\"type\":\"text\",\"info\":\"???????????,?????????????,????????????????????,????????????,?????????????????,????????????????????????\"},{\"type\":\"text\",\"info\":\"???-???&nbsp;??-???\"},{\"type\":\"text\",\"info\":\"2003?,?????????«????»?????,??????,2008?1?12????????????????????????,??????????????????????,?????????\"},{\"type\":\"text\",\"info\":\"??-???\"},{\"type\":\"text\",\"info\":\"2003?,?????????«????»?????,??????,2008?1?12????????????????????????,??????????????????????,?????????\"},{\"type\":\"text\",\"info\":\"???-???\"},{\"type\":\"text\",\"info\":\"2003?,?????????«????»?????,??????,2008?1?12????????????????????????,??????????????????????,?????????\"},{\"type\":\"text\",\"info\":\"??-???&nbsp;???-???\"},{\"type\":\"text\",\"info\":\"2004&nbsp;?,??????????«???»???????,????24????????10????????,?????????2009?6?20?,?????5?????????????,????????????9???????????,???????????????????????\"},{\"type\":\"text\",\"info\":\"???-???\"},{\"type\":\"text\",\"info\":\"2004&nbsp;?,??????????«???»???????,????24????????10????????,?????????2009?6?20?,?????5?????????????,????????????9???????????,???????????????????????\"},{\"type\":\"text\",\"info\":\"??-???&nbsp;\"},{\"type\":\"text\",\"info\":\"2004&nbsp;?,??????????«???»???????,????24????????10????????,?????????2009?6?20?,?????5?????????????,????????????9???????????,???????????????????????\"},{\"type\":\"text\",\"info\":\"???-???&nbsp;???-???\"},{\"type\":\"text\",\"info\":\"???????????????????,????????2011?10?1???,??????????????????,??:????????&nbsp;2012?5?22?,????????????5.5????,?????????????????,???????,?????\"},{\"type\":\"text\",\"info\":\"&nbsp;\"},{\"type\":\"text\",\"info\":\"&nbsp;\"},{\"type\":\"text\",\"info\":\"???-???\"},{\"type\":\"text\",\"info\":\"???????????????????,????????2011?10?1???,??????????????????,??:????????&nbsp;2012?5?22?,????????????5.5????,?????????????????,???????,????&nbsp;\"},{\"type\":\"text\",\"info\":\"&nbsp;\"},{\"type\":\"text\",\"info\":\"&nbsp;???????????????????,????????2011?10?1???,??????????????????,??:????????&nbsp;2012?5?22?,????????????5.5????,?????????????????,???????,?????&nbsp;\"},{\"type\":\"text\",\"info\":\"???-???\"},{\"type\":\"text\",\"info\":\"???????????????????,????????2011?10?1???,??????????????????,??:????????&nbsp;2012?5?22?,????????????5.5????,?????????????????,???????,?????\"},{\"type\":\"text\",\"info\":\"?S-???&nbsp;???-???\"},{\"type\":\"text\",\"info\":\"2010?9?30?,?S???????????????,2010?10?,??????,&nbsp;11?16????????,??2011?3?22?????????\"},{\"type\":\"text\",\"info\":\"???-???\"},{\"type\":\"text\",\"info\":\"2010?9?30?,?S???????????????,2010?10?,??????,&nbsp;11?16????????,??2011?3?22?????????\"},{\"type\":\"text\",\"info\":\"?S-???\"},{\"type\":\"text\",\"info\":\"2010?9?30?,?S???????????????,2010?10?,??????,&nbsp;11?16????????,??2011?3?22?????????\"},{\"type\":\"text\",\"info\":\"??-???&nbsp;???-???\"},{\"type\":\"text\",\"info\":\"????????????????????????2003??,???????????????????????????,?????????????????????,???????--???????CEO????????????????????\"},{\"type\":\"text\",\"info\":\"???-???\"},{\"type\":\"text\",\"info\":\"????????????????????????2003??,???????????????????????????,?????????????????????,???????--???????CEO????????????????????\"},{\"type\":\"text\",\"info\":\"??-???\"},{\"type\":\"text\",\"info\":\"????????????????????????2003??,???????????????????????????,?????????????????????,???????--???????CEO????????????????????\"},{\"type\":\"text\",\"info\":\"???-???&nbsp;???-???\"},{\"type\":\"text\",\"info\":\"2011?8?8?,?????????????????,?????????9???,??????????????,??????????????????:\\u201c??,????,???????,????????&nbsp;\\u201d??,?????????,??????????????,??S????????,?????\"},{\"type\":\"text\",\"info\":\"???-???\"},{\"type\":\"text\",\"info\":\"2011?8?8?,?????????????????,?????????9???,??????????????,??????????????????:\\u201c??,????,???????,????????&nbsp;\\u201d??,?????????,??????????????,??S????????,?????\"},{\"type\":\"text\",\"info\":\"???-???\"},{\"type\":\"text\",\"info\":\"2011?8?8?,?????????????????,?????????9???,??????????????,??????????????????:\\u201c??,????,???????,????????&nbsp;\\u201d??,?????????,??????????????,??S????????,?????\"},{\"type\":\"text\",\"info\":\"???-???&nbsp;???-???\"},{\"type\":\"text\",\"info\":\"2005????????,??????????,????????????????????,2005?06?19?,??????????,2009?04?03?????????,??????????,2009?12?18?????????\"},{\"type\":\"text\",\"info\":\"???-???\"},{\"type\":\"text\",\"info\":\"2005????????,??????????,????????????????????,2005?06?19?,??????????,2009?04?03?????????,??????????,2009?12?18?????????\"},{\"type\":\"text\",\"info\":\"???-???\"},{\"type\":\"text\",\"info\":\"2005????????,??????????,????????????????????,2005?06?19?,??????????,2009?04?03?????????,??????????,2009?12?18?????????\"}]";

        StringInputStream is = new StringInputStream(str);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(is);
        Iterator<JsonNode> nodeIter = root.getElements();

        while(nodeIter.hasNext())
        {
            JsonNode node = nodeIter.next();

            JsonNode typeNode = node.get("type");
            JsonNode infoNode = node.get("info");
            System.out.println(infoNode.getTextValue());
        }



    }
}