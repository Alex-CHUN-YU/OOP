import company_information.Cinema;
import company_information.Company;

/**
 *  一對一測試類別.
 */
class CompanyAndCinemaTest {
    /**
     * This is test.
     * @param args system default
     */
    public static void main(String[] args) {
        // 產生兩家公司
        Company companyOne = new Company("威秀影城股份有限公司");
        Company companySecond = new Company("日日新國際商業股份有限公司");
        // 產生兩個電影院
        Cinema cinemaOne = new Cinema("威秀");
        Cinema cinemaSecond = new Cinema("日新");
        // 一對一將公司與電影院產生實際 Link
        companyOne.addLinkToCinema(cinemaOne);
        companySecond.addLinkToCinema(cinemaSecond);
        cinemaOne.addLinkToCompany(companyOne);
        cinemaSecond.addLinkToCompany(companySecond);
        // 秀出公司所擁有之電影院
        companyOne.getCinemaOfCompany();
        companySecond.getCinemaOfCompany();
        // 秀出電影院所屬之公司
        cinemaOne.getCompanyOfCinema();
        cinemaSecond.getCompanyOfCinema();
    }
}