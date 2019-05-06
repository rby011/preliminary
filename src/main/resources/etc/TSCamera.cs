// Copyright 2016 by Samsung Electronics, Inc.,
//
// This software is the confidential and proprietary information
// of Samsung Electronics, Inc. ("Confidential Information"). You
// shall not disclose such Confidential Information and shall use
// it only in accordance with the terms of the license agreement
// you entered into with Samsung.

using NUnit.Framework;
using System;
using System.Linq;
using System.Collections;
using System.Threading;
using System.Threading.Tasks;

namespace Tizen.Multimedia.Tests
{
    [TestFixture]
    [Description("Tests Tizen.Multimedia.Camera class")]
    public class CameraTests : TestBase
    {
        private const CameraDevice _invalidDevideNumber = (CameraDevice)10;

        [Test]
        [Category("P1")]
        [Description("Test : Camera Constructor for rear camera - Object should not be null after initializing")]
        [Property("SPEC", " Tizen.Multimedia.Camera.Camera C")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "CONSTR")]
        [Property("AUTHOR", "Vivek ellur, vivek.ellur@samsung.com")]
        public void Camera_Rear_INIT()
        {
            Assert.IsInstanceOf<Camera>(TestCamera, "Should return camera instance");
        }

        [Test]
        [Category("P1")]
        [Description("Test : Camera Constructor for front camera - Object should not be null after initializing")]
        [Property("SPEC", " Tizen.Multimedia.Camera.Camera C")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "CONSTR")]
        [Property("AUTHOR", "Vivek ellur, vivek.ellur@samsung.com")]
        public void Camera_front_INIT()
        {
            // Some profiles don't support secondary camera.
            if (IsSupportedSecondaryCamera() == false)
            {
                Assert.Pass("Secondary Camera is not supported.");
            }

            using (Camera camera = new Camera(CameraDevice.Front))
            {
                Assert.IsNotNull(camera, "Object should not be null after initializing");
                Assert.IsInstanceOf<Camera>(camera, "Should return camera instance");
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test GetDeviceState method for each specific state.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.GetDeviceState M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MAE")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public async Task GetDeviceState_ENUM_ALL()
        {
            // Check NotOpened State for secondary camera.
            if (IsSupportedSecondaryCamera())
            {
                Assert.That(Camera.GetDeviceState(CameraDevice.Front), Is.EqualTo(CameraDeviceState.NotOpened));
            }

            // Check NotOpened State.
            Assert.That(Camera.GetDeviceState(CameraDevice.Rear), Is.EqualTo(CameraDeviceState.NotOpened));

            /* Opened state cannot be tested.
             * DeviceState is internally translated from NotOpened state to Working state after calling StartPreview method.
             */

            using (var eventWaiter = EventAwaiter<CameraStateChangedEventArgs>.Create())
            {
                TestCamera.StateChanged += eventWaiter;

                TestCamera.StartPreview();

                await eventWaiter.IsRaisedAsync();

                // Check Working State.
                Assert.That(Camera.GetDeviceState(CameraDevice.Rear), Is.EqualTo(CameraDeviceState.Working));
            }
        }

        [Test]
        [Category("P2")]
        [Description("Method throws ArgumentException if the specified parameter is invalid.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.GetDeviceState M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public void GetDeviceState_THROWS_IF_PARAM_IS_INVALID()
        {
            Assert.Throws<ArgumentException>(() => Camera.GetDeviceState(_invalidDevideNumber));
        }

        [Test]
        [Category("P1")]
        [Description("Test ChangeDevice method from front to rear camera and check its state.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.ChangeDevice M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MCST")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public void ChangeDevice_ENUM_DEVICE_REAR()
        {
            if (IsSupportedSecondaryCamera() == false)
            {
                Assert.Pass("Secondary Camera is not supported.");
            }

            using (Camera camera = new Camera(CameraDevice.Front))
            {
                camera.ChangeDevice(CameraDevice.Rear);
                Assert.That(camera.State, Is.EqualTo(CameraState.Created));
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test ChangeDevice method from rear to front camera and check its state.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.ChangeDevice M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MCST")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public void ChangeDevice_ENUM_DEVICE_FRONT()
        {
            if (IsSupportedSecondaryCamera() == false)
            {
                Assert.Pass("Secondary Camera is not supported.");
            }

            using (Camera camera = new Camera(CameraDevice.Front))
            {
                Assert.That(camera.State, Is.EqualTo(CameraState.Created));
            }
        }

        [Test]
        [Category("P2")]
        [Description("Method throws ArgumentException if the specified parameter is invalid.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.ChangeDevice M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public void ChangeDevice_THROWS_IF_PARAM_IS_INVALID()
        {
            Assert.Throws<ArgumentException>(() => TestCamera.ChangeDevice(_invalidDevideNumber));
        }

        [Test]
        [Category("P1")]
        [Description("Test StopPreview method by checking whether it changes the camera state to Created.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.StopPreview M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MCST")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public async Task StopPreview_CHECK_STATE()
        {
            using (var eventWaiter = EventAwaiter<CameraStateChangedEventArgs>.Create())
            {
                TestCamera.StateChanged += eventWaiter;

                TestCamera.StartPreview();

                await eventWaiter.IsRaisedAsync();
            }

            TestCamera.StopPreview();
            Assert.That(TestCamera.State, Is.EqualTo(CameraState.Created));
        }

        [Test]
        [Category("P1")]
        [Description("Test the StopContinuousCapture method.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.StartCapture M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MCST")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        [Property("COVPARAM", "int, int, CancellationToken")]
        public async Task StartCapture_CHANGE_STATUS()
        {
            TestCamera.StartPreview();

            using (var completeWaiter = EventAwaiter<CameraCapturingEventArgs>.Create())
            using (var tokenSource = new CancellationTokenSource())
            {
                try
                {
                    TestCamera.Capturing += completeWaiter;

                    TestCamera.StartCapture(10, 100, tokenSource.Token);

                    await completeWaiter.IsRaisedAsync();
                }
                catch (NotSupportedException)
                {
                    if (TestCamera.Capabilities.IsContinuousCaptureSupported)
                        Assert.Fail("Continuous capture is failed.");
                    else
                        Assert.Pass("Continuous capture feature is not supported.");
                }
                catch (Exception ex)
                {
                    Assert.Fail("Continuous capture is failed. Msg : " + ex.ToString());
                }

                /* TESTCODE */
                using (var eventWaiter = EventAwaiter<CameraStateChangedEventArgs>.Create())
                {
                    TestCamera.StateChanged += eventWaiter;

                    tokenSource.Cancel();

                    await eventWaiter.IsRaisedAsync();
                }

                Assert.That(TestCamera.State, Is.EqualTo(CameraState.Captured));
            }
        }

        [Test]
        [Category("P2")]
        [Description("Test the StartCapture method. Check that exception is occurred when CancellationTokenSource.Cancel() is called in invalid state.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.StartCapture M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        [Property("COVPARAM", "int, int, CancellationToken")]
        public async Task StartCapture_INVALID_OP_EXCEPTION()
        {
            TestCamera.StartPreview();

            using (var tokenSource = new CancellationTokenSource())
            {
                try
                {
                    TestCamera.StartCapture(3, 100, tokenSource.Token);
                    await Task.Delay(1000);
                }
                catch (NotSupportedException)
                {
                    if (TestCamera.Capabilities.IsContinuousCaptureSupported)
                        Assert.Fail("Continuous capture is failed.");
                    else
                        Assert.Pass("Continuous capture feature is not supported.");
                }
                catch (Exception ex)
                {
                    Assert.Fail("Continuous capture is failed. Msg : " + ex.ToString());
                }

                /* TESTCODE */
                try
                {
                    tokenSource.Cancel();
                }
                catch (AggregateException ex)
                {
                    ex.Handle((x) =>
                    {
                        if (x is InvalidOperationException)
                        {
                            Assert.Pass("Proper exception is occured.");
                            return true;
                        }

                        Assert.Fail("Proper exception is not occured.");
                        return false;
                    });
                }
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test StopFaceDetection method. The method should work without any exception.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.StopFaceDetection M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public void StopFaceDetection_NO_EXCEPTION()
        {
            TestCamera.StartPreview();

            try
            {
                TestCamera.StartFaceDetection();
            }
            catch (NotSupportedException)
            {
                if (TestCamera.Capabilities.IsFaceDetectionSupported)
                    Assert.Fail("Face Detection feature is supported. But StartFaceDetection returns NotSupportedException.");
                else
                    Assert.Pass("Face Detection feature is not supported.");
            }

            /* TESTCODE */
            try
            {
                TestCamera.StopFaceDetection();
            }
            catch
            {
                Assert.Fail("Exception should not be occurred.");
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test CancelFocusing method. The method should work without any exception.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.StopFocusing M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public void StopFocusing_NO_EXCEPTION()
        {
            bool isAfModeSupported = false;
            IList afModes = TestCamera.Capabilities.SupportedAutoFocusModes.ToList();
            foreach (CameraAutoFocusMode afMode in afModes)
            {
                if (afMode != CameraAutoFocusMode.None)
                {
                    TestCamera.Settings.AutoFocusMode = afMode;
                    isAfModeSupported = true;
                    break;
                }
            }

            TestCamera.StartPreview();

            try
            {
                TestCamera.StartFocusing(true);
            }
            catch (NotSupportedException)
            {
                if (isAfModeSupported)
                    Assert.Fail("StartFocusing is failed.");
                else
                    Assert.Pass("Auto focus feature is not supported.");
            }

            /* TESTCODE */
            try
            {
                TestCamera.StopFocusing();
            }
            catch
            {
                Assert.Fail("No exception should be occurred.");
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test all available camera state.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.State A")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "PRE")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public async Task State_GET_ENUM_ALL()
        {
            Assert.That(TestCamera.State, Is.EqualTo(CameraState.Created));

            TestCamera.StartPreview();
            Assert.That(TestCamera.State, Is.EqualTo(CameraState.Preview));

            using (var eventWaiter = EventAwaiter<EventArgs>.Create())
            {
                TestCamera.CaptureCompleted += eventWaiter;

                TestCamera.StartCapture();

                Assert.That(await eventWaiter.IsRaisedAsync());
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test DisplayReuseHint property whether it is set correctly or not.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.DisplayReuseHint A")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "PRW")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public async Task DisplayReuseHint_PROPERTY_READ_WRITE()
        {
            using (var eventWaiter = EventAwaiter<CameraStateChangedEventArgs>.Create())
            {
                TestCamera.StateChanged += eventWaiter;

                TestCamera.StartPreview();

                await eventWaiter.IsRaisedAsync();
            }

            TestCamera.DisplayReuseHint = true;
            Assert.IsNotNull(TestCamera.DisplayReuseHint, "display reuse hint should not be null.");
            Assert.IsTrue(TestCamera.DisplayReuseHint, "display reuse hint is not same as set value.");
        }

        [Test]
        [Category("P1")]
        [Description("Test Display property of the camera.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.Display A")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "PRO")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public void Display_PROPERTY_READ_ONLY()
        {
            /* TESTCODE
             * Test Surface Display Type.
             * Overlay type is tested always in TestBase.SetUpBase()
             */
            try
            {
                TestCamera.Display = new Display(new MediaView(CreateWindow()));
            }
            catch (NotSupportedException)
            {
                Assert.Pass("EVAS surface display type is not supported.");
            }
            catch
            {
                Assert.Fail("Set display for surface type is failed.");
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test Setting property of the camera.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.Settings A")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "PRO")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public void Settings_PROPERTY_READ_ONLY()
        {
            var result = TestCamera.Settings;
            Assert.IsNotNull(result, "setting should not be null");
            Assert.IsInstanceOf<CameraSettings>(result, "The object should be of type CameraSettings.");
        }

        [Test]
        [Category("P1")]
        [Description("Test Feature property of the camera.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.Capabilities A")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "PRO")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public void Capabilities_PROPERTY_READ_ONLY()
        {
            var result = TestCamera.Capabilities;
            Assert.IsNotNull(result, "feature should not be null");
            Assert.IsInstanceOf<CameraCapabilities>(result, "The object should be of type CameraCapabilities.");
        }

        [Test]
        [Category("P1")]
        [Description("Test DisplaySettings property of the camera.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.DisplaySettings A")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "PRO")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public void DisplaySettings_PROPERTY_READ_ONLY()
        {
            var result = TestCamera.DisplaySettings;
            Assert.IsNotNull(result, "DisplaySettings should not be null");
            Assert.IsInstanceOf<CameraDisplaySettings>(result, "The object should be of type DisplaySettings.");
        }

        [Test]
        [Category("P1")]
        [Description("Test camera direction property of the camera.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.Direction A")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "PRO")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public void Direction_PROPERTY_READ_ONLY()
        {
            CameraFacingDirection direction = TestCamera.Direction;
            Assert.IsNotNull(direction, "Camera direction should not be null.");
            Assert.IsInstanceOf<CameraFacingDirection>(direction, "The object should be of type CameraFacingDirection.");
        }

        [Test]
        [Category("P1")]
        [Description("Test Flash state property of the camera.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.GetFlashState M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MR")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public void GetFlashState_NO_EXCEPTION()
        {
            try
            {
                CameraFlashState state = Camera.GetFlashState(CameraDevice.Rear);
                Assert.IsNotNull(state, "Camera flash state should not be null.");
                Assert.IsInstanceOf<CameraFlashState>(state, "The object should be of type CameraFlashState.");
            }
            catch (NotSupportedException)
            {
                Assert.Pass("Flash feature is not supported.");
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test camera count property of the camera.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.CameraCount A")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "PRO")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public void CameraCount_PROPERTY_READ_ONLY()
        {
            var result = TestCamera.CameraCount;
            Assert.IsInstanceOf<int>(result, "The value should be of type int.");
            Assert.IsTrue(result > 0, "Wrong CameraCount value for Camera");
        }

        [Test]
        [Category("P1")]
        [Description("Test HdrCaptureProgress Event.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.HdrCaptureProgress A")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "EVL")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public async Task HdrCaptureProgress_CHECK_EVENT()
        {
            if (TestCamera.Capabilities.IsHdrCaptureSupported == false)
            {
                Assert.Pass("HDR feature is not supported.");
            }

            using (var completeWaiter = EventAwaiter.Create())
            using (var eventWaiter = EventAwaiter<HdrCaptureProgressEventArgs>.Create())
            {
                TestCamera.Settings.HdrMode = CameraHdrMode.Enable;

                TestCamera.HdrCaptureProgress += eventWaiter;
                TestCamera.CaptureCompleted += completeWaiter;

                TestCamera.StartPreview();
                TestCamera.StartCapture();

                var eventArgs = await eventWaiter.GetResultAsync();
                Assert.That(eventArgs.Percent, Is.GreaterThan(0), "HDR progress should be bigger than 0.");

                await completeWaiter.IsRaisedAsync();
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test Capturing Event.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.Capturing E")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "EVL")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public async Task Capturing_CHECK_EVENT()
        {
            using (var completeWaiter = EventAwaiter.Create())
            using (var eventWaiter = EventAwaiter<CameraCapturingEventArgs>.Create())
            {
                TestCamera.Settings.ImageQuality = 100;
                TestCamera.Settings.CapturePixelFormat = CameraPixelFormat.Jpeg;

                TestCamera.Capturing += eventWaiter;
                TestCamera.CaptureCompleted += completeWaiter;

                TestCamera.StartPreview();
                TestCamera.StartCapture();

                Assert.That(await eventWaiter.IsRaisedAsync());

                await completeWaiter.IsRaisedAsync();
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test CaptureCompleted Event.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.CaptureCompleted E")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "EVL")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public async Task CaptureCompleted_CHECK_EVENT()
        {
            using (var completeWaiter = EventAwaiter.Create())
            using (var eventWaiter = EventAwaiter<EventArgs>.Create())
            {
                TestCamera.Settings.ImageQuality = 100;
                TestCamera.Settings.CapturePixelFormat = CameraPixelFormat.Jpeg;

                TestCamera.CaptureCompleted += eventWaiter;
                TestCamera.CaptureCompleted += completeWaiter;

                TestCamera.StartPreview();
                TestCamera.StartCapture();

                Assert.That(await eventWaiter.IsRaisedAsync());

                await completeWaiter.IsRaisedAsync();
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test CameraStateChanged Event.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.StateChanged E")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "EVL")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public async Task StateChanged_CHECK_EVENT()
        {
            using (var eventWaiter = EventAwaiter<CameraStateChangedEventArgs>.Create())
            {
                TestCamera.StateChanged += eventWaiter;

                TestCamera.StartPreview();

                Assert.That(await eventWaiter.IsRaisedAsync());
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test DeviceStateChanged method.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.DeviceStateChanged E")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "EVL")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public async Task DeviceStateChanged_CHECK_EVENT()
        {
            using (var eventWaiter = EventAwaiter<CameraDeviceStateChangedEventArgs>.Create())
            {
                Camera.DeviceStateChanged += eventWaiter;

                TestCamera.StartPreview();

                Assert.That(await eventWaiter.IsRaisedAsync());
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test Interrupted Event of Camera.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.Interrupted E")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "EVL")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public void Interrupted_CHECK_EVENT()
        {
            using (var eventWaiter = EventAwaiter<CameraInterruptedEventArgs>.Create())
            {
                try
                {
                    TestCamera.Interrupted += eventWaiter;
                }
                catch (Exception ex)
                {
                    Assert.Fail("Exception is occured. msg : " + ex.ToString());
                }
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test InterruptStarted Event of Camera.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.InterruptStarted E")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "EVL")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public void InterruptStarted_CHECK_EVENT()
        {
            using (var eventWaiter = EventAwaiter<CameraInterruptStartedEventArgs>.Create())
            {
                try
                {
                    TestCamera.InterruptStarted += (s, e) => { };
                }
                catch (Exception ex)
                {
                    Assert.Fail("Exception is occured. msg : " + ex.ToString());
                }
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test ErrorOccurred event.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.ErrorOccurred E")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "EVL")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public void ErrorOccurred_CHECK_EVENT()
        {
            using (var eventWaiter = EventAwaiter<CameraErrorOccurredEventArgs>.Create())
            {
                try
                {
                    TestCamera.ErrorOccurred += (s, e) => { };
                }
                catch (Exception ex)
                {
                    Assert.Fail("Exception is occured. msg : " + ex.ToString());
                }
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test Preview event.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.Preview E")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "EVL")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public async Task Preview_CHECK_EVENT()
        {
            using (var eventWaiter = EventAwaiter<CameraStateChangedEventArgs>.Create())
            {
                TestCamera.StateChanged += eventWaiter;

                TestCamera.StartPreview();

                Assert.That(await eventWaiter.IsRaisedAsync());
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test MediaPacketPreview event.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.MediaPacketPreview E")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "EVL")]
        [Property("AUTHOR", "Vivek Ellur, vivek.ellur@samsung.com")]
        public async Task MediaPacketPreview_CHECK_EVENT()
        {
            if (TestCamera.Capabilities.IsMediaPacketPreviewCallbackSupported == false)
            {
                Assert.Pass("MediaPacketPreviewCallback feature is not supported.");
            }

            using (var eventWaiter = EventAwaiter<MediaPacketPreviewEventArgs>.Create())
            {
                TestCamera.MediaPacketPreview += eventWaiter;

                TestCamera.StartPreview();

                var eventArgs = await eventWaiter.GetResultAsync();

                Assert.IsNotNull(eventArgs.Packet);
            }
        }

        [Test]
        [Category("P1")]
        [Description("Test Camera Handle.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.Handle A")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "PRO")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public void Handle_PROPERTY_READ_ONLY()
        {
            Assert.IsNotNull(TestCamera.Handle, "Failed to get Camera Handle.");
        }

        [Test]
        [Category("P2")]
        [Description("Test Dispose method by checking whether it changes the camera state to Created.")]
        [Property("SPEC", "Tizen.Multimedia.Camera.Dispose M")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "MEX")]
        [Property("AUTHOR", "Haesu Gwon, haesu.gwon@samsung.com")]
        public void Dispose_CHECK_STATE()
        {
            TestCamera.Dispose();

            Assert.Throws<ObjectDisposedException>(() => { IntPtr handle = TestCamera.Handle; });
        }
    }
}
