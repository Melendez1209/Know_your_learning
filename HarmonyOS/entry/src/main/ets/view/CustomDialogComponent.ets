import router from '@ohos.router';
import CommonConstants from '../common/constants/CommonContants';

@CustomDialog
export default struct CustomDialogComponent {
  controller: CustomDialogController;
  cancel: () => void;
  confirm: () => void;

  build() {
    Column() {
      Text($r('app.string.dialog_text_title'))
        .width(CommonConstants.DIALOG_WIDTH_PERCENT)
        .fontColor($r('app.color.launcher_text_title_color'))
        .fontSize($r('app.float.dialog_text_privacy_size'))
        .textAlign(TextAlign.Center)
        .margin({ top: $r('app.float.dialog_text_privacy_top'),
          bottom: $r('app.float.dialog_text_privacy_bottom') })

      Text($r('app.string.dialog_text_privacy_content'))
        .fontSize($r('app.float.dialog_common_text_size'))
        .width(CommonConstants.DIALOG_COMPONENT_WIDTH_PERCENT)

      Text($r('app.string.dialog_text_privacy_statement'))
        .width(CommonConstants.DIALOG_COMPONENT_WIDTH_PERCENT)
        .fontColor($r('app.color.dialog_text_statement_color'))
        .fontSize($r('app.float.dialog_common_text_size'))
        .onClick(() => {

        })

      Text($r('app.string.dialog_text_declaration_prompt'))
        .width(CommonConstants.DIALOG_COMPONENT_WIDTH_PERCENT)
        .fontColor($r('app.color.launcher_text_title_color'))
        .fontSize($r('app.float.dialog_common_text_size'))
        .opacity($r('app.float.dialog_text_opacity'))
        .margin({ bottom: $r('app.float.dialog_text_declaration_bottom') })

      Row() {
        Text($r('app.string.dialog_button_disagree'))
          .fancy()
          .onClick(() => {
            this.controller.close();
            this.cancel
          })

        Blank()
          .backgroundColor($r('app.color.dialog_blank_background_color'))
          .width($r('app.float.dialog_blank_width'))
          .height($r('app.float.dialog_blank_height'))

        Text($r('app.string.dialog_button_agree'))
          .fancy()
          .onClick(() => {
            this.controller.close();
            this.confirm();
          })
      }
      .margin({ bottom: CommonConstants.DIALOG_ROW_MARGIN_BOTTOM })
    }
  }
}

@Extend(Text) function fancy () {
  .fontColor($r('app.color.dialog_text_statement_color'))
  .fontSize($r('app.float.dialog_fancy_text_size'))
  .textAlign(TextAlign.Center)
  .fontWeight(FontWeight.Medium)
  .layoutWeight(CommonConstants.COMMON_LAYOUT_WEIGHT)
}