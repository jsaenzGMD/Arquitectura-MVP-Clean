package pe.android.com.mvp_clean.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.List;

import pe.android.com.mvp_clean.R;

/**
 * Simple implementation of {@link MaterialDialog} with extended component basic
 * <p>
 * Created by Manuel Torres on 10/01/2017.
 */

public class DialogView {

    public interface OnSingleButton {
        /**
         * Return dialog when listener click in button
         *
         * @param poDialog {@link MaterialDialog}.
         * @author Manuel Torres
         * @version 1.0
         * @since 25/01/2017
         */
        void onClick(@NonNull MaterialDialog poDialog);
    }

    public interface OnSingleChoice {
        /**
         * Return Object when listener select item in list
         *
         * @param poObject   {@link Object} in list.
         * @param piPosition Position in list.
         * @author Manuel Torres
         * @version 1.0
         * @since 25/01/2017
         */
        void onSelection(Object poObject, int piPosition);
    }

    public interface OnMultiChoice {
        /**
         * Return list of Object when listener select multiple item in list
         *
         * @param paoObject {@link List}.
         * @author Manuel Torres
         * @version 1.0
         * @since 25/01/2017
         */
        void onSelection(List paoObject);
    }

    private final Context goContext;


    /**
     * Create instance to {@link DialogView}.
     *
     * @param poContext {@link Context}.
     * @return {@link DialogView}
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public static DialogView create(Context poContext) {
        return new DialogView(poContext);
    }

    /**
     * Constructs a {@link DialogView}.
     *
     * @param poContext {@link Context}.
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    private DialogView(Context poContext) {
        goContext = poContext;

    }

    /**
     * Show basic dialog
     *
     * @param psContent content of dialog
     * @author Malon Arteaga
     * @version 1.1
     * @since 24/10/2017
     */
    public MaterialDialog showBasicDialog(String psContent) {
        return showBasicDialog("", psContent, null, null, true);
    }

    /**
     * Show basic dialog
     *
     * @param psTitle   title of dialog
     * @param psContent content of dialog
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public MaterialDialog showBasicDialog(String psTitle, String psContent) {
        return showBasicDialog(psTitle, psContent, null, null, true);
    }

    /**
     * Show basic dialog
     *
     * @param psTitle      title of dialog
     * @param psContent    content of dialog
     * @param pbCancelable cancelable dialog
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public MaterialDialog showBasicDialog(String psTitle, String psContent, boolean pbCancelable) {
        return showBasicDialog(psTitle, psContent, null, null, pbCancelable);
    }

    /**
     * Show basic dialog
     *
     * @param psTitle                  title of dialog
     * @param psContent                content of dialog
     * @param psPositiveText           positive text of dialog
     * @param poOnSingleButtonPositive {@link OnSingleButton} Listener on click positive button
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public MaterialDialog showBasicDialog(String psTitle, String psContent,
                                          String psPositiveText, OnSingleButton poOnSingleButtonPositive) {
        return showBasicDialog(psTitle, psContent,
                psPositiveText, poOnSingleButtonPositive,
                null, null, true);
    }

    /**
     * Show basic dialog
     *
     * @param psTitle                  title of dialog
     * @param psContent                content of dialog
     * @param psPositiveText           positive text of dialog
     * @param poOnSingleButtonPositive {@link OnSingleButton} Listener on click positive button
     * @param pbCancelable             cancelable dialog
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public MaterialDialog showBasicDialog(String psTitle, String psContent,
                                          String psPositiveText, OnSingleButton poOnSingleButtonPositive,
                                          boolean pbCancelable) {
        return showBasicDialog(psTitle, psContent,
                psPositiveText, poOnSingleButtonPositive,
                null, null, pbCancelable);
    }

    /**
     * Show basic dialog
     *
     * @param psTitle                  title of dialog
     * @param psContent                content of dialog
     * @param psPositiveText           positive text of dialog
     * @param poOnSingleButtonPositive {@link OnSingleButton} Listener on click positive button
     * @param psNegativeText           negative text of dialog
     * @param poOnSingleButtonNegative {@link OnSingleButton} Listener on click negative button
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public MaterialDialog showBasicDialog(String psTitle, String psContent,
                                          String psPositiveText, OnSingleButton poOnSingleButtonPositive,
                                          String psNegativeText, OnSingleButton poOnSingleButtonNegative) {
        return showBasicDialog(psTitle, psContent,
                psPositiveText, poOnSingleButtonPositive,
                psNegativeText, poOnSingleButtonNegative,
                null, null, true);
    }

    /**
     * Show basic dialog
     *
     * @param psTitle                  title of dialog
     * @param psContent                content of dialog
     * @param psPositiveText           positive text of dialog
     * @param poOnSingleButtonPositive {@link OnSingleButton} Listener on click positive button
     * @param psNegativeText           negative text of dialog
     * @param poOnSingleButtonNegative {@link OnSingleButton} Listener on click negative button
     * @param pbCancelable             cancelable dialog
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public MaterialDialog showBasicDialog(String psTitle, String psContent,
                                          String psPositiveText, OnSingleButton poOnSingleButtonPositive,
                                          String psNegativeText, OnSingleButton poOnSingleButtonNegative,
                                          boolean pbCancelable) {
        return showBasicDialog(psTitle, psContent,
                psPositiveText, poOnSingleButtonPositive,
                psNegativeText, poOnSingleButtonNegative,
                null, null, pbCancelable);
    }

    /**
     * Show basic dialog
     *
     * @param psTitle                  title of dialog
     * @param psContent                content of dialog
     * @param psPositiveText           positive text of dialog
     * @param poOnSingleButtonPositive {@link OnSingleButton} Listener on click positive button
     * @param psNegativeText           negative text of dialog
     * @param poOnSingleButtonNegative {@link OnSingleButton} Listener on click negative button
     * @param psNeutralText            neutral text of dialog
     * @param poOnSingleButtonNeutral  {@link OnSingleButton} Listener on click neutral button
     * @param pbCancelable             cancelable dialog
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public MaterialDialog showBasicDialog(String psTitle, String psContent,
                                          String psPositiveText, OnSingleButton poOnSingleButtonPositive,
                                          String psNegativeText, OnSingleButton poOnSingleButtonNegative,
                                          String psNeutralText, OnSingleButton poOnSingleButtonNeutral,
                                          boolean pbCancelable) {

        MaterialDialog.Builder loBuilder = new MaterialDialog.Builder(goContext);
        loBuilder = defaultValueBasicDialog(loBuilder, psTitle, psContent,
                psPositiveText, poOnSingleButtonPositive,
                psNegativeText, poOnSingleButtonNegative,
                psNeutralText, poOnSingleButtonNeutral);
        loBuilder.cancelable(pbCancelable);


        return loBuilder.show();
    }


    /**
     * Show single choice dialog dialog
     *
     * @param psTitle          title of dialog
     * @param psContent        content of dialog
     * @param paoCollection    List of items
     * @param piSelectedIndex  Position index to selected
     * @param poOnSingleChoice {@link OnSingleChoice} Listener on click positive button
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public void showSingleChoiceListDialog(String psTitle, String psContent,
                                           List paoCollection, int piSelectedIndex,
                                           OnSingleChoice poOnSingleChoice) {
        showSingleChoiceListDialog(psTitle, psContent,
                paoCollection, piSelectedIndex,
                poOnSingleChoice, null);
    }

    /**
     * Show single choice dialog dialog
     *
     * @param psTitle          title of dialog
     * @param psContent        content of dialog
     * @param paoCollection    List of items
     * @param piSelectedIndex  Position index to selected
     * @param poOnSingleChoice {@link OnSingleChoice} Listener on click positive button
     * @param psPositiveText   positive text of dialog
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public void showSingleChoiceListDialog(String psTitle, String psContent,
                                           List paoCollection, int piSelectedIndex,
                                           OnSingleChoice poOnSingleChoice, String psPositiveText) {
        showSingleChoiceListDialog(psTitle, psContent,
                paoCollection, piSelectedIndex,
                poOnSingleChoice, psPositiveText,
                null, null);
    }

    /**
     * Show single choice dialog dialog
     *
     * @param psTitle                  title of dialog
     * @param psContent                content of dialog
     * @param paoCollection            List of items
     * @param piSelectedIndex          Position index to selected
     * @param poOnSingleChoice         {@link OnSingleChoice} Listener on click positive button
     * @param psPositiveText           positive text of dialog
     * @param psNegativeText           negative text of dialog
     * @param poOnSingleButtonNegative {@link OnSingleButton} Listener on click negative button
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public void showSingleChoiceListDialog(String psTitle, String psContent,
                                           List paoCollection, int piSelectedIndex,
                                           OnSingleChoice poOnSingleChoice, String psPositiveText,
                                           String psNegativeText, OnSingleButton poOnSingleButtonNegative) {
        showSingleChoiceListDialog(psTitle, psContent,
                paoCollection, piSelectedIndex,
                poOnSingleChoice, psPositiveText,
                psNegativeText, poOnSingleButtonNegative,
                null, null);
    }

    /**
     * Show single choice dialog dialog
     *
     * @param psTitle                  title of dialog
     * @param psContent                content of dialog
     * @param paoCollection            List of items
     * @param piSelectedIndex          Position index to selected
     * @param poOnSingleChoice         {@link OnSingleChoice} Listener on click positive button
     * @param psPositiveText           positive text of dialog
     * @param psNegativeText           negative text of dialog
     * @param poOnSingleButtonNegative {@link OnSingleButton} Listener on click negative button
     * @param psNeutralText            neutral text of dialog
     * @param poOnSingleButtonNeutral  {@link OnSingleButton} Listener on click neutral button
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public void showSingleChoiceListDialog(String psTitle, String psContent,
                                           final List paoCollection, int piSelectedIndex,
                                           final OnSingleChoice poOnSingleChoice, String psPositiveText,
                                           String psNegativeText, OnSingleButton poOnSingleButtonNegative,
                                           String psNeutralText, OnSingleButton poOnSingleButtonNeutral) {

        MaterialDialog.Builder loBuilder = new MaterialDialog.Builder(goContext);
        loBuilder = defaultValue(loBuilder, psTitle, psContent,
                psPositiveText, null,
                psNegativeText, poOnSingleButtonNegative,
                psNeutralText, poOnSingleButtonNeutral);
        loBuilder.items(paoCollection);
        loBuilder.itemsCallbackSingleChoice(piSelectedIndex, new MaterialDialog.ListCallbackSingleChoice() {
            @Override
            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                if (poOnSingleChoice != null && which > -1) {
                    poOnSingleChoice.onSelection(paoCollection.get(which), which);
                }
                return true;
            }
        });

        loBuilder.show();
    }

    /**
     * Show single choice dialog dialog
     *
     * @param psTitle          title of dialog
     * @param psContent        content of dialog
     * @param paoCollection    List of items
     * @param paiSelectedIndex List of positions index to selected
     * @param poOnMultiChoice  {@link OnMultiChoice} Listener on click positive button
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public void showMultiChoiceListDialog(String psTitle, String psContent,
                                          List paoCollection, Integer[] paiSelectedIndex,
                                          OnMultiChoice poOnMultiChoice) {
        showMultiChoiceListDialog(psTitle, psContent,
                paoCollection, paiSelectedIndex,
                poOnMultiChoice, null);
    }

    /**
     * Show single choice dialog dialog
     *
     * @param psTitle          title of dialog
     * @param psContent        content of dialog
     * @param paoCollection    List of items
     * @param paiSelectedIndex List of positions index to selected
     * @param poOnMultiChoice  {@link OnMultiChoice} Listener on click positive button
     * @param psPositiveText   positive text of dialog
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public void showMultiChoiceListDialog(String psTitle, String psContent,
                                          List paoCollection, Integer[] paiSelectedIndex,
                                          OnMultiChoice poOnMultiChoice, String psPositiveText) {
        showMultiChoiceListDialog(psTitle, psContent,
                paoCollection, paiSelectedIndex,
                poOnMultiChoice, psPositiveText,
                null, null);
    }

    /**
     * Show single choice dialog dialog
     *
     * @param psTitle                  title of dialog
     * @param psContent                content of dialog
     * @param paoCollection            List of items
     * @param paiSelectedIndex         List of positions index to selected
     * @param poOnMultiChoice          {@link OnMultiChoice} Listener on click positive button
     * @param psPositiveText           positive text of dialog
     * @param psNegativeText           negative text of dialog
     * @param poOnSingleButtonNegative {@link OnSingleButton} Listener on click negative button
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public void showMultiChoiceListDialog(String psTitle, String psContent,
                                          List paoCollection, Integer[] paiSelectedIndex,
                                          OnMultiChoice poOnMultiChoice, String psPositiveText,
                                          String psNegativeText, OnSingleButton poOnSingleButtonNegative) {
        showMultiChoiceListDialog(psTitle, psContent,
                paoCollection, paiSelectedIndex,
                poOnMultiChoice, psPositiveText,
                psNegativeText, poOnSingleButtonNegative,
                null, null);
    }

    /**
     * Show single choice dialog dialog
     *
     * @param psTitle                  title of dialog
     * @param psContent                content of dialog
     * @param paoCollection            List of items
     * @param paiSelectedIndex         List of positions index to selected
     * @param poOnMultiChoice          {@link OnMultiChoice} Listener on click positive button
     * @param psPositiveText           positive text of dialog
     * @param psNegativeText           negative text of dialog
     * @param poOnSingleButtonNegative {@link OnSingleButton} Listener on click negative button
     * @param psNeutralText            neutral text of dialog
     * @param poOnSingleButtonNeutral  {@link OnSingleButton} Listener on click neutral button
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public void showMultiChoiceListDialog(String psTitle, String psContent,
                                          final List paoCollection, Integer[] paiSelectedIndex,
                                          final OnMultiChoice poOnMultiChoice, String psPositiveText,
                                          String psNegativeText, OnSingleButton poOnSingleButtonNegative,
                                          String psNeutralText, OnSingleButton poOnSingleButtonNeutral) {

        MaterialDialog.Builder loBuilder = new MaterialDialog.Builder(goContext);
        loBuilder = defaultValue(loBuilder, psTitle, psContent,
                psPositiveText, null,
                psNegativeText, poOnSingleButtonNegative,
                psNeutralText, poOnSingleButtonNeutral);

        loBuilder.items(paoCollection);

        loBuilder.itemsCallbackMultiChoice(paiSelectedIndex, new MaterialDialog.ListCallbackMultiChoice() {
            @Override
            public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                if (poOnMultiChoice != null) {
                    List laoSelection = new ArrayList();
                    for (Integer liIndex : which) {
                        laoSelection.add(paoCollection.get(liIndex));
                    }
                    poOnMultiChoice.onSelection(laoSelection);
                }
                return false;
            }
        });
        loBuilder.show();
    }

    /**
     * Show indeterminate progress dialog
     *
     * @param psTitle   title of dialog
     * @param psContent content of dialog
     * @return {@link MaterialDialog}
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public MaterialDialog showIndeterminateProgressDialog(String psTitle, String psContent) {
        return showIndeterminateProgressDialog(psTitle, psContent, false);
    }

    /**
     * Show indeterminate progress dialog
     *
     * @param psTitle   title of dialog
     * @param psContent content of dialog
     * @return {@link MaterialDialog}
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public MaterialDialog showIndeterminateProgressHorizontalDialog(String psTitle, String psContent) {
        return showIndeterminateProgressDialog(psTitle, psContent, true);
    }

    /**
     * Show indeterminate progress dialog
     *
     * @param psTitle      title of dialog
     * @param psContent    content of dialog
     * @param pbHorizontal Is Horizontal true and vertical false
     * @return {@link MaterialDialog}
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    private MaterialDialog showIndeterminateProgressDialog(String psTitle,
                                                           String psContent,
                                                           boolean pbHorizontal) {
        MaterialDialog.Builder loBuilder = new MaterialDialog.Builder(goContext);
        loBuilder = defaultValue(loBuilder, psTitle, psContent, null, null,
                null, null, null, null);
        loBuilder.positiveText(null);
        loBuilder.progress(true, 0);
        loBuilder.cancelable(false);
        loBuilder.progressIndeterminateStyle(pbHorizontal);
        return loBuilder.show();
    }

    /**
     * Show determinate progress dialog
     *
     * @param psTitle            title of dialog
     * @param psContent          content of dialog
     * @param liMaxProgress      When indeterminate is false, the max value the horizontal progress
     *                           bar can get to.
     * @param poOnCancelListener {@link DialogInterface.OnCancelListener} Listener on cancel
     * @param poOnShowListener   {@link DialogInterface.OnShowListener} Lister on show
     * @return {@link MaterialDialog}
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    public MaterialDialog showDeterminateProgressDialog(String psTitle,
                                                        String psContent,
                                                        int liMaxProgress,
                                                        DialogInterface.OnCancelListener poOnCancelListener,
                                                        DialogInterface.OnShowListener poOnShowListener) {
        MaterialDialog.Builder loBuilder = new MaterialDialog.Builder(goContext);
        loBuilder = defaultValue(loBuilder, psTitle, psContent, null, null,
                null, null, null, null);
        loBuilder.positiveText(null);
        loBuilder.contentGravity(GravityEnum.CENTER);
        loBuilder.progress(false, liMaxProgress, true);
        loBuilder.cancelable(false);
        if (poOnCancelListener != null) {
            loBuilder.cancelListener(poOnCancelListener);
        }
        if (poOnShowListener != null) {
            loBuilder.showListener(poOnShowListener);
        }
        return loBuilder.show();
    }


    /**
     * Default value setter in diferents dialogs
     *
     * @param poBuilder                {@link MaterialDialog.Builder}
     * @param psTitle                  title of dialog
     * @param psContent                content of dialog
     * @param psPositiveText           positive text of dialog
     * @param poOnSingleButtonPositive {@link OnSingleButton} Listener on click positive button
     * @param psNegativeText           negative text of dialog
     * @param poOnSingleButtonNegative {@link OnSingleButton} Listener on click negative button
     * @return {@link MaterialDialog.Builder}
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    private MaterialDialog.Builder defaultValue(MaterialDialog.Builder poBuilder, String psTitle, String psContent,
                                                String psPositiveText,
                                                final OnSingleButton poOnSingleButtonPositive,
                                                String psNegativeText, final OnSingleButton poOnSingleButtonNegative,
                                                String psNeutralText, final OnSingleButton poOnSingleButtonNeutral) {
        if (!TextUtils.isEmpty(psTitle)) {
            poBuilder.title(psTitle);
        }
        if (!TextUtils.isEmpty(psContent)) {
            poBuilder.content(psContent);
        }
        if (!TextUtils.isEmpty(psPositiveText)) {
            poBuilder.positiveText(psPositiveText);
        } else {
            poBuilder.positiveText(R.string.md_posite_custom_text);
        }
        if (!TextUtils.isEmpty(psNegativeText)) {
            poBuilder.negativeText(psNegativeText);
        } else {
            poBuilder.negativeText(R.string.md_cancel_custom_text);
        }
        if (!TextUtils.isEmpty(psNeutralText)) {
            poBuilder.neutralText(psNeutralText);
        }
        if (poOnSingleButtonPositive != null) {
            poBuilder.onPositive(new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    poOnSingleButtonPositive.onClick(dialog);
                }
            });
        }
        if (poOnSingleButtonNegative != null) {
            poBuilder.onNegative(new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    poOnSingleButtonNegative.onClick(dialog);
                }
            });
        }
        if (poOnSingleButtonNeutral != null) {
            poBuilder.onNeutral(new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    poOnSingleButtonNeutral.onClick(dialog);
                }
            });
        }
        return poBuilder;
    }

    /**
     * Default value setter in diferents dialogs
     *
     * @param poBuilder                {@link MaterialDialog.Builder}
     * @param psTitle                  title of dialog
     * @param psContent                content of dialog
     * @param psPositiveText           positive text of dialog
     * @param poOnSingleButtonPositive {@link OnSingleButton} Listener on click positive button
     * @param psNegativeText           negative text of dialog
     * @param poOnSingleButtonNegative {@link OnSingleButton} Listener on click negative button
     * @return {@link MaterialDialog.Builder}
     * @author Manuel Torres
     * @version 1.0
     * @since 25/01/2017
     */
    private MaterialDialog.Builder defaultValueBasicDialog(MaterialDialog.Builder poBuilder, String psTitle, String psContent,
                                                           String psPositiveText,
                                                           final OnSingleButton poOnSingleButtonPositive,
                                                           String psNegativeText, final OnSingleButton poOnSingleButtonNegative,
                                                           String psNeutralText, final OnSingleButton poOnSingleButtonNeutral) {
        if (!TextUtils.isEmpty(psTitle)) {
            poBuilder.title(psTitle);
        } else {
            poBuilder.title(R.string.dialog_title_default);
        }
        if (!TextUtils.isEmpty(psContent)) {
            poBuilder.content(psContent);
        }
        if (!TextUtils.isEmpty(psPositiveText)) {
            poBuilder.positiveText(psPositiveText);

        } else {
            poBuilder.positiveText(R.string.md_posite_custom_text);
        }
        if (!TextUtils.isEmpty(psNegativeText)) {
            poBuilder.negativeText(psNegativeText);
        }

        if (!TextUtils.isEmpty(psNeutralText)) {
            poBuilder.neutralText(psNeutralText);
        }
        if (poOnSingleButtonPositive != null) {

            poBuilder.onPositive(new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    poOnSingleButtonPositive.onClick(dialog);

                }
            });
        }
        if (poOnSingleButtonNegative != null) {
            poBuilder.onNegative(new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    poOnSingleButtonNegative.onClick(dialog);
                }
            });
        }
        if (poOnSingleButtonNeutral != null) {
            poBuilder.onNeutral(new MaterialDialog.SingleButtonCallback() {
                @Override
                public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    poOnSingleButtonNeutral.onClick(dialog);
                }
            });
        }
        return poBuilder;
    }
}
