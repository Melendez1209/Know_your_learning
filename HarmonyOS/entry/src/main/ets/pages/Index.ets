@Entry
@Component
struct Index {
  private arr: number[] = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
  @State currentIndex: number = 0
  @State Build: Array<object> = [
    {
      text: $r('app.string.home'),
      num: 0,
      icon: $r('app.media.ic_public_home'),
      icon_filled: $r('app.media.ic_public_home_filled')

    }, {
    text: $r('app.string.analysis'),
    num: 1,
    icon: $r('app.media.ic_gallery_discover'),
    icon_filled: $r('app.media.ic_gallery_discover_filled')
  }, {
    text: $r('app.string.account'),
    num: 2,
    icon: $r('app.media.ic_public_contacts'),
    icon_filled: $r('app.media.ic_public_contacts_filled')
  }
  ]

  @Builder NavigationTitle() {
    Column() {
      Text('Title')
        .fontColor($r('app.color.launcher_text_title_color'))
        .fontSize(30)
        .lineHeight(41)
        .fontWeight(700)

      Text('subtitle')
        .fontColor($r('app.color.launcher_text_title_color'))
        .fontSize(14)
        .lineHeight(19)
        .opacity(0.4)
        .margin({ top: 2 })
    }.alignItems(HorizontalAlign.Start)
  }

  @Builder NavigationToolbar() {
    Row() {
      ForEach(this.Build, item => {
        Column() {
          Image(this.currentIndex == item.num ? item.icon_filled : item.icon)
            .height(24)
            .width(24)

          Text(item.text)
            .fontColor(this.currentIndex == item.num ? $r('app.color.dialog_text_statement_color') : $r('app.color.launcher_text_title_color'))
            .fontSize(10)
            .lineHeight(14)
            .fontWeight(500)
            .margin({ top: 3 })
        }
        .width(104)
        .height(56)
        .onClick(() => {
          this.currentIndex = item.num
        })
      })
    }.margin({ left: 24 })
  }

  build() {
    Column() {
      Navigation() {

      }
      .title(this.NavigationTitle)
      .titleMode(NavigationTitleMode.Full)
      .toolBar(this.NavigationToolbar)
      .hideTitleBar(false)
      .hideToolBar(false)
      .onTitleModeChange((titleModel: NavigationTitleMode) => {
        console.info('titleMode' + titleModel)
      })
    }.width('100%').height('100%').backgroundColor('#F1F3F5')
  }
}