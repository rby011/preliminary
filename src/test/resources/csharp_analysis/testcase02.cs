using System;
using NUnit.Framework;
using NUnit.Framework.TUnit;
using System.Threading.Tasks;
using XamarinApplication.Tizen;
using System.Collections.Generic;

namespace Xamarin.Forms.Core.UnitTests
{
    [TestFixture]
    class DatePickerTest
    {
        private static TestPage _testPage = TestPage.GetInstance();
        private static DatePicker _datePicker = null;

        [Test(Description="a")]
        [Category("P1")]
        [Description("Check DatePicker look")]
        [Property("SPEC", "Xamarin.Forms.DatePicker.Format")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "UILK")]
        [Property("AUTHOR", "Md.Elme Focruzzaman Razi, ef.razi@samsung.com")]
        [Precondition(1, "NA")]
        [Step(1, "Click run TC")]
        [Step(2, "Observe")]
        [Step(3, "Click Pass if date has been shown as \"Tuesday, March 10, 2020\", vice versa")]
        [Postcondition(1, "Click back button")]
        public async Task Date_UILK_Test()
        {
            /* TEST CODE */
            var contentPage = new ContentPage
            {
                Content = new StackLayout
                {
                    HorizontalOptions = LayoutOptions.CenterAndExpand,
                    VerticalOptions = LayoutOptions.CenterAndExpand,
                    Children =
                    {
                        new DatePicker
                        {
                            Format="D",
                            Date = new DateTime(2020,03,10),
                            VerticalOptions = LayoutOptions.CenterAndExpand
                        }
                    }
                }
            };

            _testPage.ExecuteTC(contentPage);
            await ManualTest.WaitForConfirm();
        }



        [Test]
        [Category("P2")]
        [Description("Check DatePicker look")]
        [Property("SPEC", "Xamarin.Forms.DatePicker.DatePicker ")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "UIBH")]
        [Property("AUTHOR", "Md.Elme Focruzzaman Razi, ef.razi@samsung.com")]
        [Precondition(1, "NA")]
        [Step(1, "Click run TC")]
        [Step(2, "Observe a date is showing as formate <day name, month name with date, 4 digit year>")]
        [Step(3, "Click on the date")]
        [Step(4, "Observe a Choose Date popup shown.")]
        [Step(5, "Change date and press Set button.")]
        [Step(6, "Observe the date has been changed")]
        [Step(7, "Click back button")]
        [Step(8, "Click Pass if date has been changed after press the Set button , vice versa")]
        [Postcondition(1, "Click back button")]
        public async Task DatePicker_UIBH_Test()
        {
            if (Device.Idiom == TargetIdiom.TV)
            {
                _testPage.UnlockUIButton();
                Assert.Pass("Not Supported");
            }
            /* TEST CODE */
            var contentPage = new ContentPage
            {
                Content = new StackLayout
                {
                    HorizontalOptions = LayoutOptions.CenterAndExpand,
                    VerticalOptions = LayoutOptions.CenterAndExpand,
                    Children =
                    {
                        new DatePicker
                        {
                            Format="D",
                            VerticalOptions = LayoutOptions.CenterAndExpand
                        }
                    }
                }
            };

            _testPage.ExecuteTC(contentPage);
            await ManualTest.WaitForConfirm();
        }

        [Test]
        [Category("P2")]
        [Description("Check DatePicker look")]
        [Property("SPEC", "Xamarin.Forms.DatePicker.MaximumDate")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "UIBH")]
        [Property("AUTHOR", "Md.Elme Focruzzaman Razi, ef.razi@samsung.com")]
        [Precondition(1, "NA")]
        [Step(1, "Click run TC")]
        [Step(2, "Observe a date is showing as formate <day name, month name with date, 4 digit year>")]
        [Step(3, "Click on the date")]
        [Step(4, "Observe a Choose Date popup shown.")]
        [Step(5, "Try to change date more than 10-Mar-2018.")]
        [Step(3, "Click Pass if date can not set more than 10-Mar-2018, vice versa")]
        [Postcondition(1, "Click back button")]
        public async Task MaximumDate_UIBH_Test()
        {
            if (Device.Idiom == TargetIdiom.TV)
            {
                _testPage.UnlockUIButton();
                Assert.Pass("Not Supported");
            }

            /* TEST CODE */
            var contentPage = new ContentPage
            {
                Content = new StackLayout
                {
                    HorizontalOptions = LayoutOptions.CenterAndExpand,
                    VerticalOptions = LayoutOptions.CenterAndExpand,
                    Children =
                    {
                        new DatePicker
                        {
                            Format="D",
                            MaximumDate = new DateTime(2018,03,10),
                            VerticalOptions = LayoutOptions.CenterAndExpand
                        }
                    }
                }
            };

            _testPage.ExecuteTC(contentPage);
            await ManualTest.WaitForConfirm();
        }

        [Test]
        [Category("P1")]
        [Description("Check DatePicker look")]
        [Property("SPEC", "Xamarin.Forms.DatePicker.MinimumDate")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "UIBH")]
        [Property("AUTHOR", "Md.Elme Focruzzaman Razi, ef.razi@samsung.com")]
        [Precondition(1, "NA")]
        [Step(1, "Click run TC")]
        [Step(2, "Observe a date is showing as formate <day name, month name with date, 4 digit year>")]
        [Step(3, "Click on the date")]
        [Step(4, "Observe a Choose Date popup shown.")]
        [Step(5, "Try to change date less than 10-Mar-2016.")]
        [Step(6, "Click Pass if date can not set less than 10-Mar-2016, vice versa")]
        [Postcondition(1, "Click back button")]
        public async Task MinimumDate_UIBH()
        {
            if (Device.Idiom == TargetIdiom.TV)
            {
                _testPage.UnlockUIButton();
                Assert.Pass("Not Supported");
            }

            /* TEST CODE */
            var contentPage = new ContentPage
            {
                Content = new StackLayout
                {
                    HorizontalOptions = LayoutOptions.CenterAndExpand,
                    VerticalOptions = LayoutOptions.CenterAndExpand,
                    Children =
                    {
                        new DatePicker
                        {
                            Format="D",
                            MinimumDate = new DateTime(2016,03,10),
                            VerticalOptions = LayoutOptions.CenterAndExpand
                        }
                    }
                }
            };

            _testPage.ExecuteTC(contentPage);
            await ManualTest.WaitForConfirm();
        }

        [Category("P1")]
        [Description("Check DatePicker look")]
        [Property("SPEC", "Xamarin.Forms.DatePicker.TextColor")]
        [Property("SPEC_URL", "-")]
        [Property("CRITERIA", "UILK")]
        [Property("AUTHOR", "Md.Elme Focruzzaman Razi, ef.razi@samsung.com")]
        [Precondition(1, "NA")]
        [Step(1, "Click run TC")]
        [Step(2, "Observe a date is showing as formate <day name, month name with date, 4 digit year>")]
        [Step(3, "Click Pass if text color of date is red, vice versa")]
        [Postcondition(1, "Click back button")]
        public async Task TextColor_UILK_Test()
        {
            /* TEST CODE */
            var contentPage = new ContentPage
            {
                Content = new StackLayout
                {
                    HorizontalOptions = LayoutOptions.CenterAndExpand,
                    VerticalOptions = LayoutOptions.CenterAndExpand,
                    Children =
                    {
                        new DatePicker
                        {
                            Format="D",
                            TextColor=Color.Red,
                            VerticalOptions = LayoutOptions.CenterAndExpand
                        }
                    }
                }
            };

            _testPage.ExecuteTC(contentPage);
            await ManualTest.WaitForConfirm();
        }
    }
}
