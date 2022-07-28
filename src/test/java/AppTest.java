import com.fasterxml.jackson.core.type.TypeReference;
import com.ll.exam.article.Dto.ArticleDto;
import com.ll.exam.util.Ut;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    void test_assertThat(){
        int rs = 10 + 20;
        assertThat(rs).isEqualTo(30);
    }

    @Test
    void test_ObjectMapper(){
        ArticleDto articleDto = new ArticleDto(1, "qwe", "asd");

        String jsonStr = Ut.json.toStr(articleDto, "");
        assertThat(jsonStr).isEqualTo("""
                {"id":1,"title":"qwe","body":"asd"}
                """.trim());
    }

    @Test
    void test_JsonToObj(){
        ArticleDto articleDto = new ArticleDto(1, "qwe", "asd");

        String jsonStr = Ut.json.toStr(articleDto, "");
        ArticleDto StrToObj = Ut.json.toObj(jsonStr, ArticleDto.class, null);
        assertThat(StrToObj).isEqualTo(articleDto);
    }

    @Test
    void Test_ListToJson(){
        List<ArticleDto> articleDtoList = new ArrayList<>();
        ArticleDto articleDto1 = new ArticleDto(1, "1", "1");
        ArticleDto articleDto2 = new ArticleDto(2, "2", "2");
        ArticleDto articleDto3 = new ArticleDto(3, "3", "3");
        articleDtoList.add(articleDto1);
        articleDtoList.add(articleDto2);
        articleDtoList.add(articleDto3);

        String ListToJson = Ut.json.listToJson(articleDtoList, "");

        System.out.println(ListToJson);
    }

    @Test
    void Test_JsonTOList() {
        List<ArticleDto> articleDtoList = new ArrayList<>();
        ArticleDto articleDto1 = new ArticleDto(1, "1", "1");
        ArticleDto articleDto2 = new ArticleDto(2, "2", "2");
        ArticleDto articleDto3 = new ArticleDto(3, "3", "3");
        articleDtoList.add(articleDto1);
        articleDtoList.add(articleDto2);
        articleDtoList.add(articleDto3);

        String ListToJson = Ut.json.listToJson(articleDtoList, "");

        List<ArticleDto> JsonToList = Ut.json.toObj(ListToJson, new TypeReference<>(){}, null);
        for (ArticleDto dto : JsonToList) {
            System.out.println(dto);
        }
    }

    @Test
    void Test_MapToJson() {
        Map<String, ArticleDto> map = new HashMap<>();
        ArticleDto articleDto1 = new ArticleDto(1, "1", "1");
        ArticleDto articleDto2 = new ArticleDto(2, "2", "2");
        ArticleDto articleDto3 = new ArticleDto(3, "3", "3");

        map.put("1번", articleDto1);
        map.put("2번", articleDto2);
        map.put("3번", articleDto3);

        String MapToJson = Ut.json.MapToJson(map, "");

        System.out.println(MapToJson);
    }

    @Test
    void Test_JsonToMap() {
        Map<String, ArticleDto> map = new HashMap<>();
        ArticleDto articleDto1 = new ArticleDto(1, "1", "1");
        ArticleDto articleDto2 = new ArticleDto(2, "2", "2");
        ArticleDto articleDto3 = new ArticleDto(3, "3", "3");

        map.put("1번", articleDto1);
        map.put("2번", articleDto2);
        map.put("3번", articleDto3);

        String MapToJson = Ut.json.MapToJson(map, "");

        Map<String, ArticleDto> JsonToMap = Ut.json.MaptoObj(MapToJson, new TypeReference<>(){}, null);

        System.out.println(JsonToMap);

        assertThat(map).isEqualTo(JsonToMap);
    }
}
