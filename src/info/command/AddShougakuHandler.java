package info.command;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import info.dao.InfoDAO;
import info.model.Shougaku;
import mvc.command.CommandHandler;

// 奨学情報を追加を制御するクラス
public class AddShougakuHandler implements CommandHandler
{
//	基本ページを持っている変数
  private static final String FORM_VIEW = "/WEB-INF/view/info_shougaku.jsp";
  private InfoDAO infoDAO = new InfoDAO();
  
//	要請へ従って処理
  @Override
  public String process(HttpServletRequest req, HttpServletResponse res)
      throws Exception
  {
    if (req.getMethod().equalsIgnoreCase("GET"))
    {
      return processForm(req, res);
    }
    else if (req.getMethod().equalsIgnoreCase("POST"))
    {
      return processSubmit(req, res);
    }
    else
    {
      res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
      return null;
    }
  }

// 要請がGET方式時
  private String processForm(HttpServletRequest req, HttpServletResponse res)
  {
    return FORM_VIEW;
  }

// 要請がPOST時
  private String processSubmit(HttpServletRequest req, HttpServletResponse res)
      throws SQLException
  {
// sessionからパラメータを得てShougakuクラスのメンバーへ追加
    Shougaku shougaku = new Shougaku();
    shougaku.setG_Num(req.getParameter("g_Num"));
    shougaku.setNendo(Integer.parseInt(req.getParameter("nendo")));
    shougaku.setGakki(Integer.parseInt(req.getParameter("gakki")));
    shougaku.setShou_Namae(req.getParameter("shou_Namae"));
   
//　奨学情報を加えるメソッドへパラメータを渡す
    infoDAO.shou_join(shougaku);

    return "/refresh.jsp";
  }

}// AddShougakuHandler class
