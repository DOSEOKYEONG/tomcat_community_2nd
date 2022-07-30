<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../common/head.jspf"%>
<section>
    <div class="container px-3 mx-auto">
        <h1 class="font-bold text-lg">게시물 상세페이지</h1>

        <div>
            <div>
                ID : ${article.id}
            </div>
            <div>
                TITLE : ${article.title}
            </div>
            <div>
                BODY : ${article.body}
            </div>
            <div>
                생성일자 : <fmt:parseDate value="${article.createDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedcreateDate" type="both" />
<%--                <fmt:formatDate value="${parsedcreateDate}" pattern="yyyy.MM.dd (EEE) a KK:mm" />--%>
                <fmt:formatDate value="${parsedcreateDate}" pattern="yyyy.MM.dd (EEE) HH:mm" />

            </div>
            <div>
                수정일자 : <fmt:parseDate value="${article.modifyDate}" pattern="yyyy-MM-dd'T'HH:mm" var="parsedmodifyDate" type="both" />
                <fmt:formatDate value="${parsedmodifyDate}" pattern="yyyy.MM.dd (EEE) HH:mm" />
            </div>
        </div>
    </div>
</section>
<%@ include file="../common/footer.jspf"%>