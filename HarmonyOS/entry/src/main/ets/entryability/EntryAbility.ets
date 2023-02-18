import Ability from '@ohos.application.Ability'
import Logger from '../common/utils/Logger'
import CommonConstants from '../common/constants/CommonContants'

export default class EntryAbility extends Ability {
  onCreate(want) {
    globalThis.abilityWant = want
  }

  onWindowStageCreate(windowStage) {
    Logger.info(CommonConstants.ENTRY_ABILITY_TAG, 'onWindowStageCreate');
    windowStage.loadContent('pages/LauncherPage', (err, data) => {
      if (err.code) {
        Logger.error(CommonConstants.ENTRY_ABILITY_TAG, 'Failed to load the content. Cause:' + JSON.stringify(err));
        return;
      }
      Logger.info(CommonConstants.ENTRY_ABILITY_TAG, 'Succeeded in loading the content. Data: ' + JSON.stringify(data));
    });
  }
};
