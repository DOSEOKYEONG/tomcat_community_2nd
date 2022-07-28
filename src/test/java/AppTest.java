import com.ll.exam.article.Dto.ArticleDto;
import com.ll.exam.util.Ut;
import org.junit.jupiter.api.Test;

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
}
