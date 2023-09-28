package com.example.javetest.json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.util.HashMap;
import java.util.Map;

public class JSONPathTest {
    public static void main(String[] args) {
        Map<String, JSONObject> skillLastDm = new HashMap<>();

        String info = "{\"dm\":{\"shouldEndSession\":false,\"widget\":{\"lastCurrentPage\":0,\"widgetName\":\"default\",\"duiWidget\":\"list\",\"code\":0,\"productId\":\"279601198\",\"count\":9,\"message\":\"success\",\"type\":\"list\",\"deviceName\":\"VA000202001010000000\",\"content\":[{\"subTitle\":\"南山区深南大道南山科技园汉京金融中心403号（深大站A3出口）\",\"imageUrl\":\"https://p0.meituan.net/biztone/1466437959_1690957723482.jpeg\",\"extra\":{\"wifi\":false,\"code\":0,\"address\":\"南山区深南大道南山科技园汉京金融中心403号（深大站A3出口）\",\"distance\":31,\"phone\":\"\",\"biz_ext\":{\"cost\":78,\"rating\":4.7},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=kBkP27bXKg1SkmO3qJh8TQ\",\"location\":\"22.540471,113.936551\",\"comment\":{},\"message\":\"success\",\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"辣宴·川湘家常菜（科技园汉京店）\"},{\"subTitle\":\"南山区科技中二路3号一6\",\"imageUrl\":\"https://p1.meituan.net/merchant/7c97bebc8b7a8b9f6cb5e2b834ae866c284296.jpg\",\"extra\":{\"wifi\":false,\"address\":\"南山区科技中二路3号一6\",\"distance\":143,\"phone\":\"\",\"biz_ext\":{\"cost\":83,\"rating\":4.4},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=3TxT1adYaS_GVCARnlsVOw\",\"location\":\"22.540775,113.938095\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"老湖南·甲鱼铺子·招待餐厅（南山科技园店）\"},{\"subTitle\":\"南山区粤海街道科技园社区科苑路3号综合实验楼11栋1-A2\",\"imageUrl\":\"https://img.meituan.net/content/92da40e820597eb0803b08419a459c5d197215.jpg\",\"extra\":{\"wifi\":false,\"address\":\"南山区粤海街道科技园社区科苑路3号综合实验楼11栋1-A2\",\"distance\":876,\"phone\":\"\",\"biz_ext\":{\"cost\":71,\"rating\":4.6},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=vDQRZHjy-wBXowWbReQrUw\",\"location\":\"22.542456,113.944996\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"十亩田东北铁锅炖（南山科技园店）\"},{\"subTitle\":\"南山区金鸡路田厦翡翠明珠花园1栋C7号1-24\",\"imageUrl\":\"https://img.meituan.net/content/2eebd82438a10d2960ebf3d65ce1aafb88569.jpg\",\"extra\":{\"wifi\":false,\"address\":\"南山区金鸡路田厦翡翠明珠花园1栋C7号1-24\",\"distance\":1637,\"phone\":\"\",\"biz_ext\":{\"cost\":67,\"rating\":4.8},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=375uwm_3xI5QIDuyBRzFJA\",\"location\":\"22.533499,113.922679\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"烧烤烤肉\",\"title\":\"悟能八戒烤肉（桃园店）\"},{\"subTitle\":\"南山区南新路3030号欢乐颂购物中心3楼\",\"imageUrl\":\"https://p0.meituan.net/biztone/72849348_1689132409949.jpeg\",\"extra\":{\"wifi\":false,\"address\":\"南山区南新路3030号欢乐颂购物中心3楼\",\"distance\":1813,\"phone\":\"\",\"biz_ext\":{\"cost\":64,\"rating\":4.5},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=Py-mKyYJfDqrWJ_0Iqj0VA\",\"location\":\"22.534794,113.920204\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"绿茶餐厅（欢乐颂店）\"},{\"subTitle\":\"宝安区建安一路99号海雅缤纷城购物中心5层530、531\",\"imageUrl\":\"https://p0.meituan.net/biztone/72849348_1689132409949.jpeg\",\"extra\":{\"wifi\":true,\"address\":\"宝安区建安一路99号海雅缤纷城购物中心5层530、531\",\"distance\":3882,\"phone\":\"\",\"biz_ext\":{\"cost\":66,\"rating\":4.3},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=O8cPm7Js9S_eT14ciB61lA\",\"location\":\"22.560847,113.906287\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"绿茶餐厅（海雅缤纷城店）\"},{\"subTitle\":\"南山区深南大道汉京金融中心4M-2\",\"imageUrl\":\"https://p0.meituan.net/biztone/1459163850_1687939181728.jpeg\",\"extra\":{\"wifi\":false,\"address\":\"南山区深南大道汉京金融中心4M-2\",\"distance\":31,\"phone\":\"\",\"biz_ext\":{\"cost\":195,\"rating\":4.6},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=klkZ56dyNfL8FU5wONCC2Q\",\"location\":\"22.540476,113.936566\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"观海海鲜（南山汉京店）\"},{\"subTitle\":\"南山区科技中三路1号海王银河科技大厦一楼108商铺\",\"imageUrl\":\"https://p0.meituan.net/biztone/563636331_1663228951147.jpeg\",\"extra\":{\"wifi\":false,\"address\":\"南山区科技中三路1号海王银河科技大厦一楼108商铺\",\"distance\":502,\"phone\":\"\",\"biz_ext\":{\"cost\":90,\"rating\":4.6},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=P3GL5amXS8XkNtD1F-ZdTA\",\"location\":\"22.540514,113.941679\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"火锅\",\"title\":\"就犟牛肉火锅（海王银河店）\"},{\"subTitle\":\"南山区南山大道3120号（南头古城东门斜对面）\",\"imageUrl\":\"https://p0.meituan.net/merchant/acb436733f5db949051cc46816314d12195936.jpg\",\"extra\":{\"wifi\":true,\"address\":\"南山区南山大道3120号（南头古城东门斜对面）\",\"distance\":1446,\"phone\":\"\",\"biz_ext\":{\"cost\":79,\"rating\":4.2},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=IgigJLfo0dx-rgPbYTkCZw\",\"location\":\"22.545056,113.923703\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"火锅\",\"title\":\"潮沅牛肉火锅店（南头老店）\"}],\"itemsPerPage\":3,\"extra\":{\"wifi\":false,\"code\":0,\"address\":\"南山区深南大道南山科技园汉京金融中心403号（深大站A3出口）\",\"distance\":31,\"phone\":\"\",\"biz_ext\":{\"cost\":78,\"rating\":4.7},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=kBkP27bXKg1SkmO3qJh8TQ\",\"location\":\"22.540471,113.936551\",\"comment\":{},\"message\":\"success\",\"openinfo\":\"\"},\"segment\":[{\"pinyin\":\"xia yi ye\",\"name\":\"下一页\"},{\"pinyin\":\"shang yi ye\",\"name\":\"上一页\"},{\"pinyin\":\"di yi ge\",\"name\":\"第一个\"},{\"pinyin\":\"di er ge\",\"name\":\"第二个\"},{\"pinyin\":\"di san ge\",\"name\":\"第三个\"},{\"pinyin\":\"jie dao\",\"name\":\"街道\"},{\"pinyin\":\"jia chang cai\",\"name\":\"家常菜\"},{\"pinyin\":\"hu nan\",\"name\":\"湖南\"},{\"pinyin\":\"ke ji yuan\",\"name\":\"科技园\"},{\"pinyin\":\"han jing dian\",\"name\":\"汉京店\"},{\"pinyin\":\"zhao dai\",\"name\":\"招待\"},{\"pinyin\":\"can ting\",\"name\":\"餐厅\"},{\"pinyin\":\"A er\",\"name\":\"A2\"},{\"pinyin\":\"yi yi\",\"name\":\"11\"},{\"pinyin\":\"shi shi\",\"name\":\"11\"},{\"pinyin\":\"yao yao\",\"name\":\"11\"},{\"pinyin\":\"yi shi yi\",\"name\":\"11\"},{\"pinyin\":\"shi yan lou\",\"name\":\"实验楼\"},{\"pinyin\":\"zong he\",\"name\":\"综合\"},{\"pinyin\":\"ke yuan\",\"name\":\"科苑\"},{\"pinyin\":\"she qu\",\"name\":\"社区\"},{\"pinyin\":\"ke ji\",\"name\":\"科技\"},{\"pinyin\":\"nan shan qu\",\"name\":\"南山区\"},{\"pinyin\":\"shen nan da dao\",\"name\":\"深南大道\"},{\"pinyin\":\"nan shan\",\"name\":\"南山\"},{\"pinyin\":\"han jing\",\"name\":\"汉京\"},{\"pinyin\":\"jin rong zhong xin\",\"name\":\"金融中心\"},{\"pinyin\":\"si ling san\",\"name\":\"403\"},{\"pinyin\":\"si bai ling san\",\"name\":\"403\"},{\"pinyin\":\"A san\",\"name\":\"A3\"},{\"pinyin\":\"chu kou\",\"name\":\"出口\"},{\"pinyin\":\"tie guo\",\"name\":\"铁锅\"},{\"pinyin\":\"yue hai\",\"name\":\"粤海\"},{\"pinyin\":\"dong bei\",\"name\":\"东北\"},{\"pinyin\":\"shi mu\",\"name\":\"十亩\"},{\"pinyin\":\"er lu\",\"name\":\"二路\"},{\"pinyin\":\"pu zi\",\"name\":\"铺子\"},{\"pinyin\":\"jia yu\",\"name\":\"甲鱼\"},{\"pinyin\":\"la yan\",\"name\":\"辣宴\"}],\"totalPages\":3,\"name\":\"default\",\"actualTotalPages\":3,\"currentPage\":1,\"dataSource\":\"api\"},\"intentName\":\"查询餐馆\",\"nlg\":\"找到以下结果，请说第几个，或说取消，翻页请说下一页\",\"intentId\":\"61bc9b96879822000158d0f4\",\"command\":{\"api\":\"com.aispeech.food.result\"},\"input\":\"周边美食\",\"task\":\"美食\",\"runSequence\":\"nlgFirst\",\"context\":{\"rec\":\"周边美食\",\"currentIntentName\":\"查询餐馆\"},\"speak\":{\"text\":\"找到以下结果，请说第几个，或说取消，翻页请说下一页\",\"type\":\"text\"},\"taskId\":\"5db2d0517d610d0d04565148\",\"status\":0}}";
        JSONObject jsonObject = JSONObject.parseObject(info, JSONObject.class);

        skillLastDm.put("123", jsonObject);

        JSONObject value = JSONObject.parseObject(skillLastDm.get("123").toJSONString());

        String info1 = "{\"dm\":{\"shouldEndSession\":false,\"widget\":{\"lastCurrentPage\":0,\"widgetName\":\"default\",\"duiWidget\":\"list\",\"code\":0,\"productId\":\"279601198\",\"count\":9,\"message\":\"success\",\"type\":\"list\",\"deviceName\":\"VA000202001010000000\",\"content\":[{\"subTitle\":\"南山区深南大道南山科技园汉京金融中心403号（深大站A3出口）\",\"imageUrl\":\"https://p0.meituan.net/biztone/1466437959_1690957723482.jpeg\",\"extra\":{\"wifi\":false,\"code\":0,\"address\":\"南山区深南大道南山科技园汉京金融中心403号（深大站A3出口）\",\"distance\":31,\"phone\":\"\",\"biz_ext\":{\"cost\":78,\"rating\":4.7},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=kBkP27bXKg1SkmO3qJh8TQ\",\"location\":\"22.540471,113.936551\",\"comment\":{},\"message\":\"success\",\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"辣宴·川湘家常菜（科技园汉京店）\"},{\"subTitle\":\"南山区科技中二路3号一6\",\"imageUrl\":\"https://p1.meituan.net/merchant/7c97bebc8b7a8b9f6cb5e2b834ae866c284296.jpg\",\"extra\":{\"wifi\":false,\"address\":\"南山区科技中二路3号一6\",\"distance\":143,\"phone\":\"\",\"biz_ext\":{\"cost\":83,\"rating\":4.4},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=3TxT1adYaS_GVCARnlsVOw\",\"location\":\"22.540775,113.938095\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"老湖南·甲鱼铺子·招待餐厅（南山科技园店）\"},{\"subTitle\":\"南山区粤海街道科技园社区科苑路3号综合实验楼11栋1-A2\",\"imageUrl\":\"https://img.meituan.net/content/92da40e820597eb0803b08419a459c5d197215.jpg\",\"extra\":{\"wifi\":false,\"address\":\"南山区粤海街道科技园社区科苑路3号综合实验楼11栋1-A2\",\"distance\":876,\"phone\":\"\",\"biz_ext\":{\"cost\":71,\"rating\":4.6},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=vDQRZHjy-wBXowWbReQrUw\",\"location\":\"22.542456,113.944996\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"十亩田东北铁锅炖（南山科技园店）\"},{\"subTitle\":\"南山区金鸡路田厦翡翠明珠花园1栋C7号1-24\",\"imageUrl\":\"https://img.meituan.net/content/2eebd82438a10d2960ebf3d65ce1aafb88569.jpg\",\"extra\":{\"wifi\":false,\"address\":\"南山区金鸡路田厦翡翠明珠花园1栋C7号1-24\",\"distance\":1637,\"phone\":\"\",\"biz_ext\":{\"cost\":67,\"rating\":4.8},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=375uwm_3xI5QIDuyBRzFJA\",\"location\":\"22.533499,113.922679\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"烧烤烤肉\",\"title\":\"悟能八戒烤肉（桃园店）\"},{\"subTitle\":\"南山区南新路3030号欢乐颂购物中心3楼\",\"imageUrl\":\"https://p0.meituan.net/biztone/72849348_1689132409949.jpeg\",\"extra\":{\"wifi\":false,\"address\":\"南山区南新路3030号欢乐颂购物中心3楼\",\"distance\":1813,\"phone\":\"\",\"biz_ext\":{\"cost\":64,\"rating\":4.5},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=Py-mKyYJfDqrWJ_0Iqj0VA\",\"location\":\"22.534794,113.920204\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"绿茶餐厅（欢乐颂店）\"},{\"subTitle\":\"宝安区建安一路99号海雅缤纷城购物中心5层530、531\",\"imageUrl\":\"https://p0.meituan.net/biztone/72849348_1689132409949.jpeg\",\"extra\":{\"wifi\":true,\"address\":\"宝安区建安一路99号海雅缤纷城购物中心5层530、531\",\"distance\":3882,\"phone\":\"\",\"biz_ext\":{\"cost\":66,\"rating\":4.3},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=O8cPm7Js9S_eT14ciB61lA\",\"location\":\"22.560847,113.906287\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"绿茶餐厅（海雅缤纷城店）\"},{\"subTitle\":\"南山区深南大道汉京金融中心4M-2\",\"imageUrl\":\"https://p0.meituan.net/biztone/1459163850_1687939181728.jpeg\",\"extra\":{\"wifi\":false,\"address\":\"南山区深南大道汉京金融中心4M-2\",\"distance\":31,\"phone\":\"\",\"biz_ext\":{\"cost\":195,\"rating\":4.6},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=klkZ56dyNfL8FU5wONCC2Q\",\"location\":\"22.540476,113.936566\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"中餐\",\"title\":\"观海海鲜（南山汉京店）\"},{\"subTitle\":\"南山区科技中三路1号海王银河科技大厦一楼108商铺\",\"imageUrl\":\"https://p0.meituan.net/biztone/563636331_1663228951147.jpeg\",\"extra\":{\"wifi\":false,\"address\":\"南山区科技中三路1号海王银河科技大厦一楼108商铺\",\"distance\":502,\"phone\":\"\",\"biz_ext\":{\"cost\":90,\"rating\":4.6},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=P3GL5amXS8XkNtD1F-ZdTA\",\"location\":\"22.540514,113.941679\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"火锅\",\"title\":\"就犟牛肉火锅（海王银河店）\"},{\"subTitle\":\"南山区南山大道3120号（南头古城东门斜对面）\",\"imageUrl\":\"https://p0.meituan.net/merchant/acb436733f5db949051cc46816314d12195936.jpg\",\"extra\":{\"wifi\":true,\"address\":\"南山区南山大道3120号（南头古城东门斜对面）\",\"distance\":1446,\"phone\":\"\",\"biz_ext\":{\"cost\":79,\"rating\":4.2},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=IgigJLfo0dx-rgPbYTkCZw\",\"location\":\"22.545056,113.923703\",\"comment\":{},\"openinfo\":\"\"},\"label\":\"火锅\",\"title\":\"潮沅牛肉火锅店（南头老店）\"}],\"itemsPerPage\":3,\"extra\":{\"wifi\":false,\"code\":0,\"address\":\"南山区深南大道南山科技园汉京金融中心403号（深大站A3出口）\",\"distance\":31,\"phone\":\"\",\"biz_ext\":{\"cost\":78,\"rating\":4.7},\"iurl\":\"https://runion.meituan.com/url?key=c43179bc314d9c9264c986ace33532d&url=https%3A%2F%2Fi.meituan.com%2Fshop%2Fencryptpoiid&encryptpoiid=kBkP27bXKg1SkmO3qJh8TQ\",\"location\":\"22.540471,113.936551\",\"comment\":{},\"message\":\"success\",\"openinfo\":\"\"},\"segment\":[{\"pinyin\":\"xia yi ye\",\"name\":\"下一页\"},{\"pinyin\":\"shang yi ye\",\"name\":\"上一页\"},{\"pinyin\":\"di yi ge\",\"name\":\"第一个\"},{\"pinyin\":\"di er ge\",\"name\":\"第二个\"},{\"pinyin\":\"di san ge\",\"name\":\"第三个\"},{\"pinyin\":\"jie dao\",\"name\":\"街道\"},{\"pinyin\":\"jia chang cai\",\"name\":\"家常菜\"},{\"pinyin\":\"hu nan\",\"name\":\"湖南\"},{\"pinyin\":\"ke ji yuan\",\"name\":\"科技园\"},{\"pinyin\":\"han jing dian\",\"name\":\"汉京店\"},{\"pinyin\":\"zhao dai\",\"name\":\"招待\"},{\"pinyin\":\"can ting\",\"name\":\"餐厅\"},{\"pinyin\":\"A er\",\"name\":\"A2\"},{\"pinyin\":\"yi yi\",\"name\":\"11\"},{\"pinyin\":\"shi shi\",\"name\":\"11\"},{\"pinyin\":\"yao yao\",\"name\":\"11\"},{\"pinyin\":\"yi shi yi\",\"name\":\"11\"},{\"pinyin\":\"shi yan lou\",\"name\":\"实验楼\"},{\"pinyin\":\"zong he\",\"name\":\"综合\"},{\"pinyin\":\"ke yuan\",\"name\":\"科苑\"},{\"pinyin\":\"she qu\",\"name\":\"社区\"},{\"pinyin\":\"ke ji\",\"name\":\"科技\"},{\"pinyin\":\"nan shan qu\",\"name\":\"南山区\"},{\"pinyin\":\"shen nan da dao\",\"name\":\"深南大道\"},{\"pinyin\":\"nan shan\",\"name\":\"南山\"},{\"pinyin\":\"han jing\",\"name\":\"汉京\"},{\"pinyin\":\"jin rong zhong xin\",\"name\":\"金融中心\"},{\"pinyin\":\"si ling san\",\"name\":\"403\"},{\"pinyin\":\"si bai ling san\",\"name\":\"403\"},{\"pinyin\":\"A san\",\"name\":\"A3\"},{\"pinyin\":\"chu kou\",\"name\":\"出口\"},{\"pinyin\":\"tie guo\",\"name\":\"铁锅\"},{\"pinyin\":\"yue hai\",\"name\":\"粤海\"},{\"pinyin\":\"dong bei\",\"name\":\"东北\"},{\"pinyin\":\"shi mu\",\"name\":\"十亩\"},{\"pinyin\":\"er lu\",\"name\":\"二路\"},{\"pinyin\":\"pu zi\",\"name\":\"铺子\"},{\"pinyin\":\"jia yu\",\"name\":\"甲鱼\"},{\"pinyin\":\"la yan\",\"name\":\"辣宴\"}],\"totalPages\":3,\"name\":\"default\",\"actualTotalPages\":3,\"currentPage\":1,\"dataSource\":\"api\"},\"intentName\":\"查询餐馆\",\"nlg\":\"找到以下结果，请说第几个，或说取消，翻页请说下一页\",\"intentId\":\"61bc9b96879822000158d0f4\",\"command\":{\"api\":\"com.aispeech.food.result\"},\"input\":\"周边美食\",\"task\":\"美食\",\"runSequence\":\"nlgFirst\",\"context\":{\"rec\":\"周边美食\",\"currentIntentName\":\"查询餐馆\"},\"speak\":{\"text\":\"找到以下结果，请说第几个，或说取消，翻页请说下一页\",\"type\":\"text\"},\"taskId\":\"5db2d0517d610d0d04565148\",\"status\":0}}";
        JSONObject dmOutputNew = JSONObject.parseObject(info1, JSONObject.class);

        JSONPath.set(dmOutputNew, "$.dm.widget", JSONPath.eval(value, "$.dm.widget"));

        JSONArray newDuiContent = new JSONArray();
        JSONArray duiContent = (JSONArray)JSONPath.eval(value, "$.dm.widget.content");
        JSONObject item = duiContent.getJSONObject(2);
        newDuiContent.add(item);

        JSONPath.set(dmOutputNew, "$.dm.widget.content",newDuiContent);

        System.out.println(skillLastDm.get("123").toJSONString());
    }
}
