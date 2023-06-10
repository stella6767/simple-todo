package com.example.simpletodo.util


class CustomPaginator(
    pagesPerBlock: Int,
    postsPerPage: Int,
    totalPostCount: Long
) {

    // 생성
    var pagesPerBlock = pagesPerBlock
    var postsPerPage = postsPerPage
    var totalPostCount = totalPostCount
    var totalLastPageNum : Int = setTotalLastPageNum()


    private fun setTotalLastPageNum(): Int {
        // 총 게시글 수를 기준으로 한 마지막 페이지 번호 계산
        // totalPostCount 가 0인 경우 1페이지로 끝냄
        return if (totalPostCount == 0L) {
            1
        } else {
            Math.ceil(totalPostCount!!.toDouble() / postsPerPage!!).toInt()
        }
    }

    private fun getBlock(
        currentPageNum: Int,
        isFixed: Boolean
    ): Map<String, Any?>? {
        check(!(pagesPerBlock!! % 2 == 0 && !isFixed)) { "getElasticBlock: pagesPerBlock은 홀수만 가능합니다." }
        check(!(currentPageNum > totalLastPageNum!! && totalPostCount != 0L)) { "currentPage가 총 페이지 개수($totalLastPageNum) 보다 큽니다." }

        // 블럭의 첫번째, 마지막 페이지 번호 계산
        var blockLastPageNum = totalLastPageNum
        var blockFirstPageNum = 1

        // 글이 없는 경우, 1페이지 반환.
        if (isFixed) {
            val mod = totalLastPageNum!! % pagesPerBlock!!
            if (totalLastPageNum!! - mod >= currentPageNum) {
                blockLastPageNum =
                    (Math.ceil((currentPageNum.toFloat() / pagesPerBlock!!).toDouble()) * pagesPerBlock!!).toInt()
                blockFirstPageNum = blockLastPageNum - (pagesPerBlock!! - 1)
            } else {
                blockFirstPageNum =
                    (Math.ceil((currentPageNum.toFloat() / pagesPerBlock!!).toDouble()) * pagesPerBlock!!).toInt() - (pagesPerBlock!! - 1)
            }

            // assert blockLastPageNum % pagesPerBlock == 0;
            // assert (blockFirstPageNum - 1) % pagesPerBlock == 0;
        } else {
            // 블록의 한가운데 계산 (예: 5->2, 9->4)
            val mid = pagesPerBlock!! / 2

            // 블럭의 첫번째, 마지막 페이지 번호 계산
            if (currentPageNum <= pagesPerBlock!!) {
                blockLastPageNum = pagesPerBlock
            } else if (currentPageNum < totalLastPageNum!! - mid) {
                blockLastPageNum = currentPageNum + mid
            }
            blockFirstPageNum = blockLastPageNum!! - (pagesPerBlock!! - 1)
            if (totalLastPageNum!! < pagesPerBlock!!) {
                blockLastPageNum = totalLastPageNum
                blockFirstPageNum = 1
            }
            // assert blockLastPageNum == currentPageNum + mid;
            // assert (blockFirstPageNum - 1) % pagesPerBlock == 0;
        }

        // 페이지 번호 할당
        val pageList: MutableList<Int> = ArrayList()
        var i = 0
        var `val` = blockFirstPageNum
        while (`val` <= blockLastPageNum!!) {
            pageList.add(i, `val`)
            i++
            `val`++
        }
        val result: MutableMap<String, Any?> = HashMap()
        result["isPrevExist"] = currentPageNum > pagesPerBlock as Int
        result["isNextExist"] = if (blockLastPageNum != 1) blockLastPageNum != totalLastPageNum as Int else false
        result["totalLastPageNum"] = totalLastPageNum
        result["blockLastPageNum"] = blockLastPageNum
        result["blockFirstPageNum"] = blockFirstPageNum
        result["currentPageNum"] = currentPageNum
        result["totalPostCount"] = totalPostCount
        result["pagesPerBlock"] = pagesPerBlock
        result["postsPerPage"] = postsPerPage
        result["pageList"] = pageList
        return result
    }

    fun getElasticBlock(currentPageNum: Int): Map<String, Any?>? {
        return getBlock(currentPageNum, false)
    }

    fun getFixedBlock(currentPageNum: Int): Map<String, Any?>? {
        return getBlock(currentPageNum, true)
    }


    companion object {

        fun testPage(args: Array<String>) {
            val PAGES_PER_BLOCK = 3
            val POST_PER_PAGE = 4

            // 총 게시글 수
            val totalPostCount: Long = 21
            // 인스턴스 생성
            val paginator = CustomPaginator(PAGES_PER_BLOCK, POST_PER_PAGE, totalPostCount)
            try {
                for (i in 1..paginator.totalLastPageNum) {
                    System.out.println(paginator.getElasticBlock(i))
                }
            } catch (e: Exception) {
                System.err.println(e)
            }
        }

    }



}