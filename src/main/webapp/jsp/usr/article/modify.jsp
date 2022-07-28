<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<script>
    function ArticleSave__submitForm(form) {
        form.title.value.trim();
        form.body.value.trim();
        if (form.title.value.length == 0) { // 제목 검사
            alert("제목을 입력해주세요");
            form.title.focus();
            return;
        }
        if (form.body.value.length == 0) { // 내용 검사
            alert("내용을 입력해주세요");
            form.body.focus();
            return;
        }
        form.submit();
    }
</script>
<%@ include file="../common/head.jspf" %>
<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 수정</h1>
        <form method="POST" onsubmit="ArticleSave__submitForm(this); return false;">
            <div class="flex gap-3">
                <span>번호</span>
                <div>
                    ${article.id}
                </div>
            </div>

            <div class="flex gap-3">
                <span>제목</span>
                <div>
                    <input name="title" type="text" maxlength="50" placeholder="제목을 입력해주세요."
                           value="${article.title}"/>
                </div>
            </div>

            <div class="flex gap-3">
                <span>내용</span>
                <div>
                    <input name="body" type="text" maxlength="300" placeholder="내용을 입력해주세요."
                           value="${article.title}"/>
                </div>
            </div>

            <div>
                <div>
                    <input class="hover:underline hover:text-[red] cursor-pointer" type="submit" value="수정"/>
                </div>
            </div>
        </form>
    </div>
    </div>
</section>
<%@ include file="../common/footer.jspf" %>
</%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
