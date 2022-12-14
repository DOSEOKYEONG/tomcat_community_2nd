<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="../common/head.jspf"%>

<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 리스트</h1>

        <ul class="mt-5">
           <c:forEach items="${articleDtoList}" var="article">
               <fmt:parseDate value="${article.createDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedcreateDate" type="both" />
               <%--                <fmt:formatDate value="${parsedcreateDate}" pattern="yyyy.MM.dd (EEE) a KK:mm" />--%>
               <li class="flex">
                   <a class="w-[40px] hover:underline hover:text-[red]" href="/usr/article/detail/free/${article.id}">${article.id}</a>
                   <a class="flex-grow hover:underline hover:text-[red]" href="/usr/article/detail/free/${article.id}">${article.title}</a>
                   <a class="flex-grow"><fmt:formatDate value="${parsedcreateDate}" pattern="yyyy.MM.dd (EEE) HH:mm" /></a>
                   <a onclick="if ( !confirm('정말로 삭제하시겠습니까?') ) return false;" class="hover:underline hover:text-[red] mr-2" href="/usr/article/delete/free/${article.id}">삭제</a>
                   <a class="hover:underline hover:text-[red]" href="/usr/article/modify/free/${article.id}%>">수정</a>
               </li>
           </c:forEach>

        </ul>
    </div>
</section>

<section class="mt-5">
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">테스트</h1>
        <script>
            function Article__loadLatest() {
                fetch('/usr/article/getArticles/free')
                    .then(data => data.json()) // JSON을 파싱
                    .then(responseData => {
                        const articleList = responseData.data;
                        console.log(articleList);
                        const latestArticle = articleList[articleList.length - 1];
                        const contents = new Date() + " : " + latestArticle.title + "<br />";

                        // $('.place-1').append(content); // 아래로 추가
                        $('.place-1').prepend(contents); // 위로 추가
                        // $('.place-1').empty().prepend(content); // 기존 내용을 비우고 위로 추가
                    });
            }
        </script>
        <button onclick="Article__loadLatest();" class="btn btn-xs">최신글 가져오기</button>

        <div class="place-1 border-2 border-[red] min-h-[500px]">

        </div>
    </div>
</section>

<%@ include file="../common/footer.jspf"%>