import com.fasterxml.jackson.core.type.TypeReference;
import com.ll.exam.article.Dto.ArticleDto;
import com.ll.exam.article.Dto.ArticleDto_;
import com.ll.exam.util.Ut;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void test_assertThat(){
        int rs = 10 + 20;
        assertThat(rs).isEqualTo(30);
    }

//    @Test
//    void test_ObjectMapper(){
//        ArticleDto articleDto = new ArticleDto(1, "qwe", "asd");
//
//        String jsonStr = Ut.json.toStr(articleDto, "");
//        assertThat(jsonStr).isEqualTo("""
//                {"id":1,"title":"qwe","body":"asd"}
//                """.trim());
//    }
//
//    @Test
//    void test_JsonToObj(){
//        ArticleDto articleDto = new ArticleDto(1, "qwe", "asd");
//
//        String jsonStr = Ut.json.toStr(articleDto, "");
//        ArticleDto StrToObj = Ut.json.toObj(jsonStr, ArticleDto.class, null);
//        assertThat(StrToObj).isEqualTo(articleDto);
//    }
//
//    @Test
//    void Test_ListToJson(){
//        List<ArticleDto> articleDtoList = new ArrayList<>();
//        ArticleDto articleDto1 = new ArticleDto(1, "1", "1");
//        ArticleDto articleDto2 = new ArticleDto(2, "2", "2");
//        ArticleDto articleDto3 = new ArticleDto(3, "3", "3");
//        articleDtoList.add(articleDto1);
//        articleDtoList.add(articleDto2);
//        articleDtoList.add(articleDto3);
//
//        String ListToJson = Ut.json.listToJson(articleDtoList, "");
//
//        System.out.println(ListToJson);
//    }
//
//    @Test
//    void Test_JsonTOList() {
//        List<ArticleDto> articleDtoList = new ArrayList<>();
//        ArticleDto articleDto1 = new ArticleDto(1, "1", "1");
//        ArticleDto articleDto2 = new ArticleDto(2, "2", "2");
//        ArticleDto articleDto3 = new ArticleDto(3, "3", "3");
//        articleDtoList.add(articleDto1);
//        articleDtoList.add(articleDto2);
//        articleDtoList.add(articleDto3);
//
//        String ListToJson = Ut.json.listToJson(articleDtoList, "");
//
//        List<ArticleDto> JsonToList = Ut.json.toObj(ListToJson, new TypeReference<>(){}, null);
//        for (ArticleDto dto : JsonToList) {
//            System.out.println(dto);
//        }
//    }
//
//    @Test
//    void Test_MapToJson() {
//        Map<String, ArticleDto> map = new HashMap<>();
//        ArticleDto articleDto1 = new ArticleDto(1, "1", "1");
//        ArticleDto articleDto2 = new ArticleDto(2, "2", "2");
//        ArticleDto articleDto3 = new ArticleDto(3, "3", "3");
//
//        map.put("1번", articleDto1);
//        map.put("2번", articleDto2);
//        map.put("3번", articleDto3);
//
//        String MapToJson = Ut.json.MapToJson(map, "");
//
//        System.out.println(MapToJson);
//    }
//
//    @Test
//    void Test_JsonToMap() {
//        Map<String, ArticleDto> map = new HashMap<>();
//        ArticleDto articleDto1 = new ArticleDto(1, "1", "1");
//        ArticleDto articleDto2 = new ArticleDto(2, "2", "2");
//        ArticleDto articleDto3 = new ArticleDto(3, "3", "3");
//
//        map.put("1번", articleDto1);
//        map.put("2번", articleDto2);
//        map.put("3번", articleDto3);
//
//        String MapToJson = Ut.json.MapToJson(map, "");
//
//        Map<String, ArticleDto> JsonToMap = Ut.json.toObj(MapToJson, new TypeReference<>(){}, null);
//
//        System.out.println(JsonToMap);
//
//        assertThat(map).isEqualTo(JsonToMap);
//    }
//
//    @Test
//    void Testdd(){
//        List<ArticleDto> articleDtoList = new ArrayList<>();
//        ArticleDto articleDto1 = new ArticleDto(1, "1", "1");
//        ArticleDto articleDto2 = new ArticleDto(2, "2", "2");
//        ArticleDto articleDto3 = new ArticleDto(3, "3", "3");
//        articleDtoList.add(articleDto1);
//        articleDtoList.add(articleDto2);
//        articleDtoList.add(articleDto3);
//
//        Map<String, Object> resultData = Ut.mapOf("resultCode", "S-1", "msg", "성공", "Data", articleDtoList);
//
//        System.out.println(resultData);
//    }

    @Test
    void test_ArticleDto2_(){
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).format(localDateTime));
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(localDateTime));
//        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).format(localDateTime));
        // 디비 > 받아 올 때 표시 형식
        System.out.println(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(localDateTime));

//        String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG));
//        String createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        System.out.println(createdDate);

        ArticleDto_ articleDto_ = new ArticleDto_(1, "1", "1", localDateTime, localDateTime);

        System.out.println(articleDto_.toString());

    }

    @Test
    void articleDto_추가(){

    }
}
