package elpisclothing.StepsDefinitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import elpisclothing.pageObjects.Product_ViewDetail_PageObject;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;

@SuppressWarnings({ "deprecation" })
public class Product_ViewDetal_PageDefinitions {
	@Steps
	Product_ViewDetail_PageObject viewPro;

	@Then("^Product-ViewDetailPage: kiểm tra mở trang Xem chi tiết sản phẩm thành công với button Thêm vào giỏ hàng được hiển thị$")
	public void productviewdetailpage_kim_tra_m_trang_xem_chi_tit_sn_phm_thnh_cng_vi_text_something_c_hin_th() {
		viewPro.verifyOpenViewPage();
	}

	@Given("^Product-ViewDetailPage: chọn thông tin sản phẩm$")
	public void productviewdetailpage_chn_thng_tin_sn_phm(DataTable table) {
		String title = viewPro.getValueColumnDataTableBDD(table, "tieuDe");
		String size = viewPro.getValueColumnDataTableBDD(table, "kichThuoc");

		viewPro.dynamicSelectTitleLabel(title);
		viewPro.dynamicSelectSizeLabel(size);
	}

	@And("^Product-ViewDetailPage: lấy thông tin Tên, Giá tiền, Tiêu đề, Kích thước của sản phẩm đã chọn$")
	public void productviewdetailpage_ly_thng_tin_tn_gi_tin_tiu_kch_thc_ca_sn_phm_chn(DataTable table) {
		ShareContextData.NAME_select = viewPro.getNamePro();
		ShareContextData.PRICE_select = viewPro.getPricePro();
		
		ShareContextData.TITLE_select = viewPro.getValueColumnDataTableBDD(table, "tieuDe");
		ShareContextData.SIZE_select = viewPro.getValueColumnDataTableBDD(table, "kichThuoc");

	}

	@And("^Product-ViewDetailPage: nhấn button Thêm vào giỏ hàng$")
	public void productviewdetailpage_nhn_button_thm_vo_gi_hng() {
		viewPro.clickToAddBtn();
	}
}
