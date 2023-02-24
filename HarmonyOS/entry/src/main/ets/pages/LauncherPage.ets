import AppContext from '@ohos.application.context';
import DataPreferences from '@ohos.data.preferences';
import Router from '@ohos.router';
import CommonConstants from '../common/constants/CommonContants';
import CustomDialogComponent from '../view/CustomDialogComponent';
import Logger from '../common/utils/Logger'

@Entry
@Component
struct LauncherPage {
  private context: AppContext.AbilityContext;
  private timerId: number = 0;
  private jumpToAdvertisingFlag: boolean = false;
  dialogController: CustomDialogController = new CustomDialogController({
    builder: CustomDialogComponent(
      {
        cancel: this.onCancel.bind(this),
        confirm: this.onConfirm.bind(this)
      }),
    alignment: DialogAlignment.Bottom,
    offset: { dx: 0, dy: CommonConstants.DIALOG_CONTROLLER_DY_OFFSET },
    customStyle: true,
    autoCancel: false
  });

  onCancel() {
    // Exit the application.
    this.context.terminateSelf();
  }

  onConfirm() {
    // Save privacy agreement status.
    this.saveIsPrivacy();
    this.jumpToAdvertisingPage();
  }

  onPageHide() {
    if (this.jumpToAdvertisingFlag) {
      Router.clear();
    }
    clearTimeout(this.timerId);
  }

  aboutToAppear() {
    this.context = getContext(this) as AppContext.AbilityContext;
    // Get the operation class for saving data.
    this.getDataPreferences().then((preferences: DataPreferences.Preferences) => {
      preferences.get(CommonConstants.PREFERENCES_KEY_PRIVACY, true)
        .then((value: DataPreferences.ValueType) => {
          Logger.info(CommonConstants.LAUNCHER_PAGE_TAG, 'AboutToAppear value: ' + value)
          if (true) {
            this.dialogController.open()
          } else {
            this.jumpToAdvertisingPage()
          }
        })
    })
  }

  getDataPreferences() {
    return DataPreferences.getPreferences(this.context, 'LearningStore')
  }

  saveIsPrivacy() {
    let preferences: Promise<DataPreferences.Preferences> = this.getDataPreferences();
    preferences.then((result: DataPreferences.Preferences) => {
      let privacyPut = result.put(CommonConstants.PREFERENCES_KEY_PRIVACY, false);
      result.flush();
      privacyPut.then(() => {
        Logger.info(CommonConstants.LAUNCHER_PAGE_TAG, 'Put the value of startup Successfully.');
      }).catch((err) => {
        Logger.error(CommonConstants.LAUNCHER_PAGE_TAG, 'Put the value of startup Failed, err: ' + err);
      });
    }).catch((err) => {
      Logger.error(CommonConstants.LAUNCHER_PAGE_TAG, 'Get the preferences Failed, err: ' + err);
    });
  }

  /**
   * Jump to advertising page.
   */
  jumpToAdvertisingPage() {
    this.timerId = setTimeout(() => {
      this.jumpToAdvertisingFlag = true;
      Router.push({ url: CommonConstants.ADVERTISING_PAGE_URL });
    }, CommonConstants.LAUNCHER_DELAY_TIME);
  }

  build() {
    Stack() {
      Column() {
        Image($r('app.media.icon'))
          .width($r('app.float.launcher_logo_size'))
          .height($r('app.float.launcher_logo_size'))
          .margin({ top: CommonConstants.LAUNCHER_IMAGE_MARGIN_TOP })

        Text($r('app.string.app_name'))
          .width($r('app.float.launcher_life_text_width'))
          .height($r('app.float.launcher_life_text_height'))
          .margin({ top: CommonConstants.LAUNCHER_TEXT_TITLE_MARGIN_TOP })
          .appTextStyle(FontWeight.Bold,
          CommonConstants.LAUNCHER_LIFE_TEXT_SPACING,
          $r('app.float.launcher_text_title_size'),
          $r('app.color.launcher_text_title_color'))

        Text($r('app.string.app_introduce'))
          .height(CommonConstants.LAUNCHER_TEXT_INTRODUCE_HEIGHT)
          .margin({ top: CommonConstants.LAUNCHER_TEXT_INTRODUCE_MARGIN_TOP })
          .opacity($r('app.float.launcher_text_opacity'))
          .appTextStyle(FontWeight.Normal,
          CommonConstants.LAUNCHER_TEXT_INTRODUCE_SPACING,
          $r('app.float.launcher_text_introduce_size'),
          $r('app.color.launcher_text_title_color'))
      }
      .width(CommonConstants.FULL_WIDTH)
      .height(CommonConstants.FULL_HEIGHT)
    }
  }
}

@Extend(Text) function appTextStyle (fontWeight: number, textAttribute: number, fontSize: Resource, fontColor: Resource) {
  .fontWeight(fontWeight)
  .letterSpacing(textAttribute)
  .fontSize(fontSize)
  .fontColor(fontColor)
}

