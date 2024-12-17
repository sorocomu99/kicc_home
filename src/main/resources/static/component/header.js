class HeaderComponent extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
            <a class="navbar-brand col-md-3 col-lg-2 me-0" href="#">KICC 관리자</a>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse"
                data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="right-link">
                <div class="item">
                    <a class="px-3" href="../" target="_blank"><span data-feather="home"></span> 홈페이지</a>
                </div>
                <div class="item">
                    <a class="px-3" href="../login/index.html"><span data-feather="log-out"></span> 로그아웃</a>
                </div>
            </div>
        </header>
        <nav class="sidebar" id="sidebarMenu">
            <div class="position-sticky pt-3">
                <div class="sidebar-nav accordion accordion-flush" id="accordionSideBarNavigation">
                    <div class="accordion-item">
                        <h2 class="accordion-header">
                            <button disabled class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panel1" aria-expanded="true" aria-controls="panel1">
                                <i data-feather="settings"></i>
                                기본설정 관리
                            </button>
                        </h2>
                        <div id="panel1" class="accordion-collapse collapse show">
                            <div class="accordion-body">
                                <a class="nav-link active" href="../setting/account_admin.html">관리자 계정 관리</a>
                                <a class="nav-link" href="../setting/popup.html">팝업 관리</a>
                                <a class="nav-link" href="../setting/receiver.html">문의 수신 담당자 설정</a>
                                <a class="nav-link" href="../setting/privacy.html">개인정보처리방침 관리</a>
                                <a class="nav-link" href="../setting/terms.html">이용약관 관리</a>
                                <a class="nav-link" href="../setting/inquiry.html">전자금융 문의 관리</a>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#pannel2" aria-expanded="false" aria-controls="pannel2">
                                <span data-feather="grid"></span>
                                메인 관리
                            </button>
                        </h2>
                        <div id="pannel2" class="accordion-collapse collapse">
                            <div class="accordion-body">
                                <a class="nav-link" href="../main/visual.html">메인 비주얼 관리</a>
                                <a class="nav-link" href="../main/business.html">사업영역 관리</a>
                                <a class="nav-link" href="../main/products.html">제품 소개 관리</a>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#pannel3" aria-expanded="false" aria-controls="pannel3">
                                <span data-feather="package"></span>
                                제품 관리
                            </button>
                        </h2>
                        <div id="pannel3" class="accordion-collapse collapse">
                            <div class="accordion-body">
                                <a class="nav-link" href="../products/pos.html">POS 관리</a>
                                <a class="nav-link" href="../products/kiosk.html">KIOSK 관리</a>
                                <a class="nav-link" href="../products/card.html">카드단말기관리</a>
                                <a class="nav-link" href="../products/sign.html">사인패드 관리</a>
                                <a class="nav-link" href="../products/etc.html">기타 관리</a>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#pannel4" aria-expanded="false" aria-controls="pannel4">
                                <span data-feather="hexagon"></span>
                                기업정보 관리
                            </button>
                        </h2>
                        <div id="pannel4" class="accordion-collapse collapse">
                            <div class="accordion-body">
                                <a class="nav-link" href="../page/about.html">KICC 소개 관리</a>
                                <a class="nav-link" href="../page/stockholder.html">주주총회 관리</a>
                                <a class="nav-link" href="../page/ir.html">IR Letter 관리</a>
                                <a class="nav-link" href="../page/public.html">전자공고 관리</a>
                                <a class="nav-link" href="../page/bridging_introduce.html">브리징 - 소개 관리</a>
                                <a class="nav-link" href="../page/bridging.html">브리징 - 활동내역 관리</a>
                                <a class="nav-link" href="../page/news.html">소식 관리</a>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#pannel5" aria-expanded="false" aria-controls="pannel5">
                                <span data-feather="users"></span>
                                채용관리
                            </button>
                        </h2>
                        <div id="pannel5" class="accordion-collapse collapse">
                            <div class="accordion-body">
                                <a class="nav-link" href="../page/recruit.html">채용 공고 관리</a>
                                <a class="nav-link" href="../page/resume.html">이력서 관리</a>
                                <a class="nav-link" href="../page/notice.html">공지사항 관리</a>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2 class="accordion-header">
                            <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#pannel6" aria-expanded="false" aria-controls="pannel6">
                                <span data-feather="message-circle"></span>
                                고객지원 관리
                            </button>
                        </h2>
                        <div id="pannel6" class="accordion-collapse collapse">
                            <div class="accordion-body">
                                <a class="nav-link" href="../board/notice.html">공지사항 관리</a>
                                <a class="nav-link" href="../board/download.html">자료실 관리</a>
                                <a class="nav-link" href="../page/voc.html">VOC 문의 관리</a>
                                <a class="nav-link" href="../page/curriculum.html">커리큘럼 관리</a>
                                <a class="nav-link" href="../page/seminar.html">세미나 신청 관리</a>
                                <a class="nav-link" href="../board/faq.html">자주하는 질문 관리</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
      `;
    }
}

customElements.define('app-header', HeaderComponent);