using NUnit.Framework;
using NUnit.Framework.TUnit;

namespace Tizen.Applications.Tests
{
    [TestFixture]
    [Description("AppControlReceivedEventArgs test")]
        public class AppControlReceivedEventArgsTests
        {

        //private Tizen.Applications.AppControl appCtrl;

        [SetUp]
        public void Init()
        {
            LogUtils.Write(LogUtils.DEBUG, LogUtils.TAG, "Preconditions for each TEST");
        }

        [TearDown]
        public void Destroy()
        {
            LogUtils.Write(LogUtils.DEBUG, LogUtils.TAG, "Postconditions for each TEST");
        }

        [Test]
        [Category("P1")]
        [Description("Test : AppControlReceivedEventArgs should not null after initializing")]
        [Property("SPEC", "Tizen.Applications.AppControlReceivedEventArgs.AppControlReceivedEventArgs C")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "CONSTR")]
        [Property("AUTHOR", "Dao Trong Hieu, tronghieu.d@samsung.com")]
        public void AppControlReceivedEventArgs_INIT()
        {
            /* TEST CODE */
            AppControl MyAppControl = new AppControl();
            SafeAppControlHandle SafeHandle = MyAppControl.SafeAppControlHandle;
            ReceivedAppControl receiveAppCtrl = new ReceivedAppControl(SafeHandle);
            var _appctrlReceivedArgs = new AppControlReceivedEventArgs(receiveAppCtrl);
            Assert.IsNotNull(_appctrlReceivedArgs, "AppControlReceivedEventArgs should not null after initializing");
            Assert.IsInstanceOf<AppControlReceivedEventArgs>(_appctrlReceivedArgs);
        }
    }

}
