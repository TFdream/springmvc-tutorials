package apple.springmvc.zxing.controller;

import apple.springmvc.zxing.model.User;
import apple.springmvc.zxing.service.QRCodeService;
import apple.springmvc.zxing.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * @author Ricky Fung
 */
@Controller
@RequestMapping("/qr")
public class QRCodeController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String uploadPath = "/images" ;
    private int width = 300;
    private int height = 300;

    @Autowired
    private UserService userService;

    @Autowired
    private QRCodeService qrCodeService;

    @RequestMapping(value = "/encode/{userId}", method = RequestMethod.GET)
    public ModelAndView genQR(@PathVariable Long userId, HttpServletRequest request){

        User user =  userService.getUser(userId);

        String realUploadPath = request.getServletContext().getRealPath(uploadPath);
        logger.info("realUploadPath:{}", realUploadPath);

        File uploadDir = new File(realUploadPath);
        if(!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String imageName = String.format("%s_qr.png", userId);
        File qrFile = new File(uploadDir, imageName);
        qrCodeService.encode(user.toString(), width, height, qrFile);
        logger.info("生成的二维码文件:{}", qrFile.getAbsolutePath());


        File logoFile = new File(uploadDir, "logo.png");
        imageName = String.format("%s_qr_logo.png", userId);
        File logoQrFile = new File(uploadDir, imageName);
        qrCodeService.encodeWithLogo(qrFile, logoFile, logoQrFile);
        logger.info("生成的带logo二维码文件:{}", logoQrFile.getAbsolutePath());

        ModelAndView mv = new ModelAndView("show_qr");
        mv.addObject("userId", userId);
        mv.addObject("qrImage", uploadPath+"/"+qrFile.getName());
        mv.addObject("logoQRImage", uploadPath+"/"+logoQrFile.getName());
        return mv;
    }

    @RequestMapping(value = "/decode/{userId}", method = RequestMethod.GET)
    public ModelAndView decodeQR(@PathVariable Long userId, HttpServletRequest request){
        User user =  userService.getUser(userId);

        String realUploadPath = request.getServletContext().getRealPath(uploadPath) ;
        File uploadDir = new File(realUploadPath);

        String imageName = String.format("%s_qr.png", userId);
        File qrFile = new File(uploadDir, imageName);
        String result = qrCodeService.decode(qrFile);

        ModelAndView mv = new ModelAndView("decode_qr") ;
        mv.addObject("result", result);
        return mv;
    }
}
